package com.study.captcha.utils;

import java.awt.*;
import java.util.Random;

/**
 * @Description: 验证码工具类
 * @Author: rands
 * @Date: Created in 10:26 2020/5/29
 * @Modified By:
 */
public class CaptchaUtils {
    /*生成验证码宽度*/
    public static final int WIDTH = 150;
    /*生成验证码高度*/
    public static final int HEIGHT = 38;

    public static Font font[] = {
            new Font(FontEnum.getFontNameInfo("10000"), Font.BOLD, 24),
            new Font(FontEnum.getFontNameInfo("100001"), Font.BOLD, 24)
    };

    public static void setBackGround(Graphics g) {
        /*设置颜色*/
        g.setColor(Color.WHITE);
        /*填充区域*/
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    /**
     * 设置图片边框
     *
     * @param g
     */
    public static void setBorder(Graphics g) {
        /*设置边框颜色*/
        g.setColor(Color.WHITE);
        /*边框区域*/
        g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
    }

    /**
     * 图片上随机划线
     *
     * @param g
     */
    public static void drawRandomLines(Graphics g) {
        /*设置线条并画线*/
        for (int i = 0; i < 3; i++) {
            //设置颜色
            g.setColor(getRandColorCode());
            int x1 = new Random().nextInt(WIDTH / 2);
            int y1 = new Random().nextInt(HEIGHT / 2);
            int x2 = new Random().nextInt(WIDTH) + WIDTH / 2;
            int y2 = new Random().nextInt(HEIGHT) + HEIGHT / 2;
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2.5f));
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 创建随机字符
     * @param g
     * @param character
     * @return
     */
    public static String GenerateRandomCharacters(Graphics2D g, String character) {
        StringBuffer sbf = new StringBuffer();
        int x = 15;
        String ch = "";
        for (int i = 0; i < 4; i++) {
            g.setFont(font[new Random().nextInt(font.length - 1)]);
            g.setColor(getRandColorCode());
            // 设置字体旋转角度
            int degree = new Random().nextInt() % 30;
            ch = character.charAt(new Random().nextInt(character.length())) + "";
            sbf.append(ch);
            // 正向角度
            g.rotate(degree * Math.PI / 180, x, 33);
            g.drawString(ch, x, 33);
            // 反向角度
            g.rotate(-degree * Math.PI / 180, x, 33);
            x += 25;
        }
        return sbf.toString();
    }

    /**
     * String... createTypeFlag是可变参数，
     * @param g
     * @param createTypeFlag
     * @return
     */
    public static String drawRandomCharacter(Graphics2D g, String... createTypeFlag){
        //设置颜色
        g.setColor(Color.RED);
        // 设置字体
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        //常用的中国汉字
        String baseChineseChar ="的一了是我不在人们有来他这上着个地到大里说就去子得也和那要下看天时过出小么起你都把好还多没为又可家学只以主会样年想生同老中十从自面前头道它后然走很像见两用她国动进成回什边作对开而己些现山民候经发工向事命给长水几义三声于高手知理眼志点心战二问但身方实吃做叫当住听革打呢真全才四已所敌之最光产情路分总条白话东席次亲如被花口放儿常气五第使写军吧文运再果怎定许快明行因别飞外树物活部门无往船望新带队先力完却站代员机更九您每风级跟笑啊孩万少直意夜比阶连车重便斗马哪化太指变社似士者干石满日决百原拿群究各六本思解立河村八难早论吗根共让相研今其书坐接应关信觉步反处记将千找争领或师结块跑谁草越字加脚紧爱等习阵怕月青半火法题建赶位唱海七女任件感准张团屋离色脸片科倒睛利世刚且由送切星导晚表够整认响雪流未场该并底深刻平伟忙提确近亮轻讲农古黑告界拉名呀土清阳照办史改历转画造嘴此治北必服雨穿内识验传业菜爬睡兴形量咱观苦体众通冲合破友度术饭公旁房极南枪读沙岁线野坚空收算至政城劳落钱特围弟胜教热展包歌类渐强数乡呼性音答哥际旧神座章帮啦受系令跳非何牛取入岸敢掉忽种装顶急林停息句区衣般报叶压慢叔背细";
        //数字和字母的组合
        String baseNumLetter = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        //纯数字
        String baseNum = "0123456789";
        //纯字母
        String baseLetter = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        if(createTypeFlag.length>0 && null!=createTypeFlag[0]){
            if (createTypeFlag[0].equals("ch")) {
                // 截取汉字
                return GenerateRandomCharacters(g, baseChineseChar);
            } else if (createTypeFlag[0].equals("nl")) {
                // 截取数字和字母的组合
                return GenerateRandomCharacters(g, baseNumLetter);
            } else if (createTypeFlag[0].equals("n")) {
                // 截取数字
                return GenerateRandomCharacters(g, baseNum);
            } else if (createTypeFlag[0].equals("l")) {
                // 截取字母
                return GenerateRandomCharacters(g, baseLetter);
            }
        }else{
            // 默认截取数字和字母的组合
            return GenerateRandomCharacters(g, baseNumLetter);
        }
        return "";
    }

    public static Color getRandColorCode() {
        int r, g, b;
        Random random = new Random();

        r = random.nextInt(256);
        g = random.nextInt(256);
        b = random.nextInt(256);
        Color color = new Color(r, g, b);
        return color;
    }
}
