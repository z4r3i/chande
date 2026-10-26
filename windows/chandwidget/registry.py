"""
Direct port of PriceItem.java + PriceRegistry.java from the Android app.
Keep this list in sync with the Android registry — same keys, same order.
"""
from dataclasses import dataclass
from enum import Enum
from collections import OrderedDict


class PriceType(Enum):
    CURRENCY_TOMAN = "CURRENCY_TOMAN"
    GOLD_TOMAN = "GOLD_TOMAN"
    CRYPTO_USD = "CRYPTO_USD"
    GOLD_USD = "GOLD_USD"


@dataclass(frozen=True)
class PriceItem:
    key: str
    name_en: str
    name_fa: str
    symbol_en: str
    symbol_fa: str
    emoji: str
    type: PriceType


# Keys from 4mir.ir API
KEY_USD = "price_dollar_rl"
KEY_EUR = "price_eur"
KEY_GBP = "price_gbp"
KEY_AED = "price_aed"
KEY_KWD = "price_kwd"
KEY_TRY = "price_try"
KEY_CHF = "price_chf"
KEY_CNY = "price_cny"
KEY_CAD = "price_cad"
KEY_RUB = "price_rub"
KEY_IQD = "price_iqd"
KEY_INR = "price_inr"

KEY_GOLD18 = "geram18"
KEY_GOLD24 = "geram24"
KEY_SEKKE = "sekee"
KEY_SEKBE = "sekeb"
KEY_NIM = "retail_nim"
KEY_ROB = "rob"

KEY_BTC = "crypto-bitcoin"
KEY_ETH = "crypto-ethereum"
KEY_TRX = "crypto-tron"
KEY_XRP = "crypto-ripple"
KEY_SOL = "crypto-solana"
KEY_DOGE = "crypto-dogecoin"
KEY_GRAM = "crypto-gram"
KEY_BNB = "crypto-binance-coin"
KEY_ADA = "crypto-cardano"
KEY_LINK = "crypto-chainlink"
KEY_LTC = "crypto-litecoin"
KEY_SHIB = "crypto-shiba-inu"

ALL: "OrderedDict[str, PriceItem]" = OrderedDict()


def _add(key, en, fa, sym_en, sym_fa, emoji, type_):
    ALL[key] = PriceItem(key, en, fa, sym_en, sym_fa, emoji, type_)


# Currencies
_add(KEY_USD, "US Dollar", "دلار آمریکا", "USD", "USD", "$", PriceType.CURRENCY_TOMAN)
_add(KEY_EUR, "Euro", "یورو", "EUR", "EUR", "€", PriceType.CURRENCY_TOMAN)
_add(KEY_GBP, "British Pound", "پوند انگلیس", "GBP", "GBP", "£", PriceType.CURRENCY_TOMAN)
_add(KEY_AED, "UAE Dirham", "درهم امارات", "AED", "AED", "AED", PriceType.CURRENCY_TOMAN)
_add(KEY_KWD, "Kuwaiti Dinar", "دینار کویت", "KWD", "KWD", "د.ك", PriceType.CURRENCY_TOMAN)
_add(KEY_TRY, "Turkish Lira", "لیر ترکیه", "TRY", "TRY", "₺", PriceType.CURRENCY_TOMAN)
_add(KEY_CHF, "Swiss Franc", "فرانک سوئیس", "CHF", "CHF", "CHF", PriceType.CURRENCY_TOMAN)
_add(KEY_CNY, "Chinese Yuan", "یوان چین", "CNY", "CNY", "¥", PriceType.CURRENCY_TOMAN)
_add(KEY_CAD, "Canadian Dollar", "دلار کانادا", "CAD", "CAD", "C$", PriceType.CURRENCY_TOMAN)
_add(KEY_RUB, "Russian Ruble", "روبل روسیه", "RUB", "RUB", "₽", PriceType.CURRENCY_TOMAN)
_add(KEY_IQD, "Iraqi Dinar", "دینار عراق", "IQD", "IQD", "ع.د", PriceType.CURRENCY_TOMAN)
_add(KEY_INR, "Indian Rupee", "روپیه هند", "INR", "INR", "₹", PriceType.CURRENCY_TOMAN)

# Gold
_add(KEY_GOLD18, "Gold 18K", "طلا ۱۸ عیار", "G18", "طلا", "🥇", PriceType.GOLD_TOMAN)
_add(KEY_GOLD24, "Gold 24K", "طلا ۲۴ عیار", "G24", "طلا", "🥇", PriceType.GOLD_TOMAN)
_add(KEY_SEKKE, "Full Coin", "سکه تمام", "COIN", "سکه", "🪙", PriceType.GOLD_TOMAN)
_add(KEY_SEKBE, "Azadi Coin", "سکه بهار آزادی", "AZD", "بهار", "🪙", PriceType.GOLD_TOMAN)
_add(KEY_NIM, "Half Coin", "نیم سکه", "HALF", "نیم", "🪙", PriceType.GOLD_TOMAN)
_add(KEY_ROB, "Quarter Coin", "ربع سکه", "QTR", "ربع", "🪙", PriceType.GOLD_TOMAN)

# Crypto
_add(KEY_BTC, "Bitcoin", "بیتکوین", "BTC", "BTC", "₿", PriceType.CRYPTO_USD)
_add(KEY_ETH, "Ethereum", "اتریوم", "ETH", "ETH", "Ξ", PriceType.CRYPTO_USD)
_add(KEY_TRX, "Tron", "ترون", "TRX", "TRX", "🔺", PriceType.CRYPTO_USD)
_add(KEY_DOGE, "Dogecoin", "دوج کوین", "DOGE", "DOGE", "🐕", PriceType.CRYPTO_USD)
_add(KEY_SOL, "Solana", "سولانا", "SOL", "SOL", "◎", PriceType.CRYPTO_USD)
_add(KEY_XRP, "XRP", "ریپل", "XRP", "XRP", "✕", PriceType.CRYPTO_USD)
_add(KEY_GRAM, "gram", "گرام", "GRAM", "GRAM", "💎", PriceType.CRYPTO_USD)
_add(KEY_BNB, "Binance", "بایننس", "BNB", "BNB", "🔶", PriceType.CRYPTO_USD)
_add(KEY_ADA, "Cardano", "کاردانو", "ADA", "ADA", "🎴", PriceType.CRYPTO_USD)
_add(KEY_LINK, "Chainlink", "چین لینک", "LINK", "LINK", "🔗", PriceType.CRYPTO_USD)
_add(KEY_LTC, "Litecoin", "لایت کوین", "LTC", "LTC", "Ł", PriceType.CRYPTO_USD)
_add(KEY_SHIB, "Shiba Inu", "شیبا اینو", "SHIB", "SHIB", "🐶", PriceType.CRYPTO_USD)


def get_all():
    return list(ALL.values())


def get(key: str):
    return ALL.get(key)
