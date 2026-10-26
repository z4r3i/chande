"""
API wrapper for 4mir.ir price data.
"""
import logging
from dataclasses import dataclass
from typing import Optional, Dict, Any

import requests
import urllib3

from . import registry as R

urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)

log = logging.getLogger("4mir_api")

API_URL = "https://4mir.ir/price/api.php"
TIMEOUT = 12

_HEADERS = {"User-Agent": "ChandWidget-Win/1.0", "Accept": "application/json"}


@dataclass
class PriceData:
    key: str
    price: float
    change: float


def _parse_double(s) -> float:
    try:
        return float(str(s).replace(",", "").strip())
    except (ValueError, TypeError):
        return 0.0


def _http_get_json(url: str):
    try:
        resp = requests.get(url, headers=_HEADERS, timeout=TIMEOUT)
        if resp.status_code != 200:
            return None
        return resp.json()
    except requests.exceptions.SSLError:
        try:
            resp = requests.get(url, headers=_HEADERS, timeout=TIMEOUT, verify=False)
            if resp.status_code != 200:
                return None
            return resp.json()
        except Exception as e:
            log.error("httpGet retry (no verify) failed: %s (%s)", url, e)
            return None
    except Exception as e:
        log.error("httpGet error: %s (%s)", url, e)
        return None


def fetch(key: str) -> Optional[PriceData]:
    try:
        data = _http_get_json(API_URL)
        if not data:
            return None

        item = _find_item(data, key)
        if not item:
            log.warning("Key not found: %s", key)
            return None

        price = _parse_double(item.get("price", "0"))
        change_obj = item.get("change", {})
        change_val = _parse_double(str(change_obj.get("value", "0")))
        direction = change_obj.get("direction", "")

        change = -abs(change_val) if direction == "down" else abs(change_val)
        return PriceData(key, price, change)
    except Exception as e:
        log.error("fetch error for %s: %s", key, e)
        return None


def _find_item(data: Dict[str, Any], key: str) -> Optional[Dict[str, Any]]:
    for category in ["fiat", "gold", "crypto"]:
        if category in data and key in data[category]:
            return data[category][key]
    return None
