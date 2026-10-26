package com.saeed.chandwidget.data;

public class PriceItem {
    // 4mir.ir API keys
    // Currencies (fiat category)
    public static final String KEY_USD    = "price_dollar_rl";
    public static final String KEY_EUR    = "price_eur";
    public static final String KEY_GBP    = "price_gbp";
    public static final String KEY_AED    = "price_aed";
    public static final String KEY_KWD    = "price_kwd";
    public static final String KEY_TRY    = "price_try";
    public static final String KEY_CHF    = "price_chf";
    public static final String KEY_CNY    = "price_cny";
    public static final String KEY_CAD    = "price_cad";
    public static final String KEY_RUB    = "price_rub";
    public static final String KEY_IQD    = "price_iqd";
    public static final String KEY_INR    = "price_inr";

    // Gold (gold category)
    public static final String KEY_GOLD18 = "geram18";
    public static final String KEY_GOLD24 = "geram24";
    public static final String KEY_SEKKE  = "sekee";   // سکه تمام
    public static final String KEY_SEKBE  = "sekeb";   // سکه بهار آزادی
    public static final String KEY_NIM    = "retail_nim"; // نیم سکه
    public static final String KEY_ROB    = "rob";     // ربع سکه

    // Crypto (crypto category)
    public static final String KEY_BTC    = "crypto-bitcoin";
    public static final String KEY_ETH    = "crypto-ethereum";
    public static final String KEY_TRX    = "crypto-tron";
    public static final String KEY_XRP    = "crypto-ripple";
    public static final String KEY_SOL    = "crypto-solana";
    public static final String KEY_DOGE   = "crypto-dogecoin";
    public static final String KEY_GRAM   = "crypto-gram";
    public static final String KEY_BNB    = "crypto-binance-coin";
    public static final String KEY_ADA    = "crypto-cardano";
    public static final String KEY_LINK   = "crypto-chainlink";
    public static final String KEY_LTC    = "crypto-litecoin";
    public static final String KEY_SHIB   = "crypto-shiba-inu";

    public enum PriceType {
        CURRENCY_TOMAN,
        GOLD_TOMAN,
        CRYPTO_USD,
    }

    private final String key;
    private final String nameEn;
    private final String nameFa;
    private final String symbolEn;
    private final String symbolFa;
    private final String emoji;
    private final PriceType type;

    public PriceItem(String key, String nameEn, String nameFa,
                     String symbolEn, String symbolFa, String emoji, PriceType type) {
        this.key = key;
        this.nameEn = nameEn;
        this.nameFa = nameFa;
        this.symbolEn = symbolEn;
        this.symbolFa = symbolFa;
        this.emoji = emoji;
        this.type = type;
    }

    public String getKey()      { return key; }
    public String getNameEn()   { return nameEn; }
    public String getNameFa()   { return nameFa; }
    public String getSymbolEn() { return symbolEn; }
    public String getSymbolFa() { return symbolFa; }
    public String getEmoji()    { return emoji; }
    public PriceType getType()  { return type; }
}
