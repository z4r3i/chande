package com.saeed.chandwidget.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PriceRegistry {

    public static final Map<String, PriceItem> ALL = new LinkedHashMap<>();

    static {
        // Currencies
        add(PriceItem.KEY_USD,    "US Dollar",        "دلار آمریکا",     "USD", "USD",  "$", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_EUR,    "Euro",             "یورو",            "EUR", "EUR",  "€", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_GBP,    "British Pound",    "پوند انگلیس",    "GBP", "GBP",  "£", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_AED,    "UAE Dirham",       "درهم امارات",    "AED", "AED",  "AED", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_KWD,    "Kuwaiti Dinar",    "دینار کویت",     "KWD", "KWD",  "د.ك", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_TRY,    "Turkish Lira",     "لیر ترکیه",      "TRY", "TRY",  "₺", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_CHF,    "Swiss Franc",      "فرانک سوئیس",   "CHF", "CHF",  "CHF", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_CNY,    "Chinese Yuan",     "یوان چین",       "CNY", "CNY",  "¥", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_CAD,    "Canadian Dollar",  "دلار کانادا",    "CAD", "CAD",  "C$", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_RUB,    "Russian Ruble",    "روبل روسیه",     "RUB", "RUB",  "₽", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_IQD,    "Iraqi Dinar",      "دینار عراق",     "IQD", "IQD",  "ع.د", PriceItem.PriceType.CURRENCY_TOMAN);
        add(PriceItem.KEY_INR,    "Indian Rupee",     "روپیه هند",      "INR", "INR",  "₹", PriceItem.PriceType.CURRENCY_TOMAN);
        // Gold
        add(PriceItem.KEY_GOLD18, "Gold 18K",         "طلا ۱۸ عیار",   "G18", "طلا", "🥇", PriceItem.PriceType.GOLD_TOMAN);
        add(PriceItem.KEY_GOLD24, "Gold 24K",         "طلا ۲۴ عیار",   "G24", "طلا", "🥇", PriceItem.PriceType.GOLD_TOMAN);
        add(PriceItem.KEY_SEKKE,  "Full Coin",        "سکه تمام",      "COIN", "سکه", "🪙", PriceItem.PriceType.GOLD_TOMAN);
        add(PriceItem.KEY_SEKBE,  "Azadi Coin",       "سکه بهار آزادی","AZD", "بهار", "🪙", PriceItem.PriceType.GOLD_TOMAN);
        add(PriceItem.KEY_NIM,    "Half Coin",        "نیم سکه",       "HALF", "نیم", "🪙", PriceItem.PriceType.GOLD_TOMAN);
        add(PriceItem.KEY_ROB,    "Quarter Coin",     "ربع سکه",       "QTR",  "ربع", "🪙", PriceItem.PriceType.GOLD_TOMAN);
        // Crypto
        add(PriceItem.KEY_BTC,    "Bitcoin",          "بیتکوین",        "BTC",  "BTC", "₿",  PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_ETH,    "Ethereum",         "اتریوم",         "ETH",  "ETH", "Ξ",  PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_TRX,    "Tron",             "ترون",           "TRX",  "TRX", "🔺", PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_DOGE,   "Dogecoin",         "دوج کوین",      "DOGE", "DOGE","🐕", PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_SOL,    "Solana",           "سولانا",         "SOL",  "SOL", "◎",  PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_XRP,    "XRP",              "ریپل",           "XRP",  "XRP", "✕",  PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_GRAM,   "gram",             "گرام",         "GRAM", "GRAM", "💎", PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_BNB,    "Binance",          "بایننس",         "BNB",  "BNB", "🔶", PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_ADA,    "Cardano",          "کاردانو",        "ADA",  "ADA", "🎴", PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_LINK,   "Chainlink",        "چین لینک",      "LINK", "LINK", "🔗", PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_LTC,    "Litecoin",         "لایت کوین",      "LTC",  "LTC", "Ł",  PriceItem.PriceType.CRYPTO_USD);
        add(PriceItem.KEY_SHIB,   "Shiba Inu",        "شیبا اینو",     "SHIB", "SHIB", "🐶", PriceItem.PriceType.CRYPTO_USD);
    }

    private static void add(String key, String en, String fa,
                             String symEn, String symFa, String emoji,
                             PriceItem.PriceType type) {
        ALL.put(key, new PriceItem(key, en, fa, symEn, symFa, emoji, type));
    }

    public static List<PriceItem> getAll() {
        return new ArrayList<>(ALL.values());
    }

    public static PriceItem get(String key) {
        return ALL.get(key);
    }
}
