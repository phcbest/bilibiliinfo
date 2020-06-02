package com.phc.bilibiliinfo.gsonBean;

/**
 * 版权：没有版权 看得上就用
 *
 * @author peng
 * 创建日期：2020/5/28 15
 * 描述：
 */
public class bilibiliup {

    /**
     * code : 0
     * message : 0
     * ttl : 1
     * data : {"mid":2,"name":"碧诗","sex":"男","face":"http://i0.hdslb.com/bfs/app/3e60b20604b6fdc7d081eb6a1ec72aa47c5a3964.jpg","sign":"kami.im 直男过气网红 # av362830 \u201cWe Are Star Dust\u201d","rank":20000,"level":6,"jointime":0,"moral":0,"silence":0,"birthday":"09-19","coins":0,"fans_badge":true,"official":{"role":2,"title":"bilibili创始人（站长）","desc":"","type":0},"vip":{"type":2,"status":1,"theme_type":0},"pendant":{"pid":1141,"name":"如果历史是一群喵","image":"http://i2.hdslb.com/bfs/garb/item/cd3e9a6fa18db9ebdc128b0fef64cb32c5aab854.png","expire":0,"image_enhance":"http://i2.hdslb.com/bfs/garb/item/cd3e9a6fa18db9ebdc128b0fef64cb32c5aab854.png"},"nameplate":{"nid":10,"name":"见习偶像","image":"http://i1.hdslb.com/bfs/face/e93dd9edfa7b9e18bf46fd8d71862327a2350923.png","image_small":"http://i1.hdslb.com/bfs/face/275b468b043ec246737ab8580a2075bee0b1263b.png","level":"普通勋章","condition":"所有自制视频总播放数>=10万"},"is_followed":true,"top_photo":"http://i1.hdslb.com/bfs/space/cb1c3ef50e22b6096fde67febe863494caefebad.png","theme":{},"sys_notice":{}}
     */

    private int code;
    private String message;
    private int ttl;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * mid : 2
         * name : 碧诗
         * sex : 男
         * face : http://i0.hdslb.com/bfs/app/3e60b20604b6fdc7d081eb6a1ec72aa47c5a3964.jpg
         * sign : kami.im 直男过气网红 # av362830 “We Are Star Dust”
         * rank : 20000
         * level : 6
         * jointime : 0
         * moral : 0
         * silence : 0
         * birthday : 09-19
         * coins : 0
         * fans_badge : true
         * official : {"role":2,"title":"bilibili创始人（站长）","desc":"","type":0}
         * vip : {"type":2,"status":1,"theme_type":0}
         * pendant : {"pid":1141,"name":"如果历史是一群喵","image":"http://i2.hdslb.com/bfs/garb/item/cd3e9a6fa18db9ebdc128b0fef64cb32c5aab854.png","expire":0,"image_enhance":"http://i2.hdslb.com/bfs/garb/item/cd3e9a6fa18db9ebdc128b0fef64cb32c5aab854.png"}
         * nameplate : {"nid":10,"name":"见习偶像","image":"http://i1.hdslb.com/bfs/face/e93dd9edfa7b9e18bf46fd8d71862327a2350923.png","image_small":"http://i1.hdslb.com/bfs/face/275b468b043ec246737ab8580a2075bee0b1263b.png","level":"普通勋章","condition":"所有自制视频总播放数>=10万"}
         * is_followed : true
         * top_photo : http://i1.hdslb.com/bfs/space/cb1c3ef50e22b6096fde67febe863494caefebad.png
         * theme : {}
         * sys_notice : {}
         */

        private int mid;
        private String name;
        private String sex;
        private String face;
        private String sign;
        private int rank;
        private int level;
        private int jointime;
        private int moral;
        private int silence;
        private String birthday;
        private int coins;
        private boolean fans_badge;
        private OfficialBean official;
        private VipBean vip;
        private PendantBean pendant;
        private NameplateBean nameplate;
        private boolean is_followed;
        private String top_photo;
        private ThemeBean theme;
        private SysNoticeBean sys_notice;

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getJointime() {
            return jointime;
        }

        public void setJointime(int jointime) {
            this.jointime = jointime;
        }

        public int getMoral() {
            return moral;
        }

        public void setMoral(int moral) {
            this.moral = moral;
        }

        public int getSilence() {
            return silence;
        }

        public void setSilence(int silence) {
            this.silence = silence;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getCoins() {
            return coins;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public boolean isFans_badge() {
            return fans_badge;
        }

        public void setFans_badge(boolean fans_badge) {
            this.fans_badge = fans_badge;
        }

        public OfficialBean getOfficial() {
            return official;
        }

        public void setOfficial(OfficialBean official) {
            this.official = official;
        }

        public VipBean getVip() {
            return vip;
        }

        public void setVip(VipBean vip) {
            this.vip = vip;
        }

        public PendantBean getPendant() {
            return pendant;
        }

        public void setPendant(PendantBean pendant) {
            this.pendant = pendant;
        }

        public NameplateBean getNameplate() {
            return nameplate;
        }

        public void setNameplate(NameplateBean nameplate) {
            this.nameplate = nameplate;
        }

        public boolean isIs_followed() {
            return is_followed;
        }

        public void setIs_followed(boolean is_followed) {
            this.is_followed = is_followed;
        }

        public String getTop_photo() {
            return top_photo;
        }

        public void setTop_photo(String top_photo) {
            this.top_photo = top_photo;
        }

        public ThemeBean getTheme() {
            return theme;
        }

        public void setTheme(ThemeBean theme) {
            this.theme = theme;
        }

        public SysNoticeBean getSys_notice() {
            return sys_notice;
        }

        public void setSys_notice(SysNoticeBean sys_notice) {
            this.sys_notice = sys_notice;
        }

        public static class OfficialBean {
            /**
             * role : 2
             * title : bilibili创始人（站长）
             * desc :
             * type : 0
             */

            private int role;
            private String title;
            private String desc;
            private int type;

            public int getRole() {
                return role;
            }

            public void setRole(int role) {
                this.role = role;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class VipBean {
            /**
             * type : 2
             * status : 1
             * theme_type : 0
             */

            private int type;
            private int status;
            private int theme_type;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getTheme_type() {
                return theme_type;
            }

            public void setTheme_type(int theme_type) {
                this.theme_type = theme_type;
            }
        }

        public static class PendantBean {
            /**
             * pid : 1141
             * name : 如果历史是一群喵
             * image : http://i2.hdslb.com/bfs/garb/item/cd3e9a6fa18db9ebdc128b0fef64cb32c5aab854.png
             * expire : 0
             * image_enhance : http://i2.hdslb.com/bfs/garb/item/cd3e9a6fa18db9ebdc128b0fef64cb32c5aab854.png
             */

            private int pid;
            private String name;
            private String image;
            private int expire;
            private String image_enhance;

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getExpire() {
                return expire;
            }

            public void setExpire(int expire) {
                this.expire = expire;
            }

            public String getImage_enhance() {
                return image_enhance;
            }

            public void setImage_enhance(String image_enhance) {
                this.image_enhance = image_enhance;
            }
        }

        public static class NameplateBean {
        }

        public static class ThemeBean {
        }

        public static class SysNoticeBean {
        }
    }
}
