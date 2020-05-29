package com.study.captcha.utils;

/**
 * @Description:
 * @Author: rands
 * @Date: Created in 10:29 2020/5/29
 * @Modified By:
 */
public enum FontEnum {
    SongT("宋体", "10000"),
    KaiT("楷体", "100002");

    private String fontName;
    private String fontCode;

    FontEnum(String fontName, String fontCode) {
        this.fontName = fontName;
        this.fontCode = fontCode;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public String getFontCode() {
        return fontCode;
    }

    public void setFontCode(String fontCode) {
        this.fontCode = fontCode;
    }

    public static String getFontNameInfo(String fontCode) {
        for (FontEnum fontEnum : FontEnum.values()) {
            if (fontEnum.getFontCode().equals(fontCode)) {
                return fontEnum.getFontName();
            }
        }
        return null;
    }
}
