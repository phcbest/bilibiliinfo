package com.phc.bilibiliinfo.gsonBean;

import com.google.gson.annotations.SerializedName;

/**
 * 版权：没有版权 看得上就用
 *
 * @author peng
 * 创建日期：2020/5/26 16
 * 描述：
 */
public class bilibilionline {

    /**
     * code : 0
     * message : 0
     * ttl : 1
     * data : {"region_count":{"1":3122,"11":4,"119":220,"129":898,"13":109,"138":3623,"155":1709,"160":33999,"165":2,"167":276,"17":6642,"177":217,"181":7733,"188":1173,"202":127,"23":3,"3":5070,"36":8143,"4":27943,"5":5708,"75":2355,"76":1957}}
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
         * region_count : {"1":3122,"11":4,"119":220,"129":898,"13":109,"138":3623,"155":1709,"160":33999,"165":2,"167":276,"17":6642,"177":217,"181":7733,"188":1173,"202":127,"23":3,"3":5070,"36":8143,"4":27943,"5":5708,"75":2355,"76":1957}
         */

        private RegionCountBean region_count;

        public RegionCountBean getRegion_count() {
            return region_count;
        }

        public void setRegion_count(RegionCountBean region_count) {
            this.region_count = region_count;
        }

        public static class RegionCountBean {
            /**
             * 1 : 3122
             * 11 : 4
             * 119 : 220
             * 129 : 898
             * 13 : 109
             * 138 : 3623
             * 155 : 1709
             * 160 : 33999
             * 165 : 2
             * 167 : 276
             * 17 : 6642
             * 177 : 217
             * 181 : 7733
             * 188 : 1173
             * 202 : 127
             * 23 : 3
             * 3 : 5070
             * 36 : 8143
             * 4 : 27943
             * 5 : 5708
             * 75 : 2355
             * 76 : 1957
             */

            @SerializedName("1")
            private int _$1;
            @SerializedName("11")
            private int _$11;
            @SerializedName("119")
            private int _$119;
            @SerializedName("129")
            private int _$129;
            @SerializedName("13")
            private int _$13;
            @SerializedName("138")
            private int _$138;
            @SerializedName("155")
            private int _$155;
            @SerializedName("160")
            private int _$160;
            @SerializedName("165")
            private int _$165;
            @SerializedName("167")
            private int _$167;
            @SerializedName("17")
            private int _$17;
            @SerializedName("177")
            private int _$177;
            @SerializedName("181")
            private int _$181;
            @SerializedName("188")
            private int _$188;
            @SerializedName("202")
            private int _$202;
            @SerializedName("23")
            private int _$23;
            @SerializedName("3")
            private int _$3;
            @SerializedName("36")
            private int _$36;
            @SerializedName("4")
            private int _$4;
            @SerializedName("5")
            private int _$5;
            @SerializedName("75")
            private int _$75;
            @SerializedName("76")
            private int _$76;

            public int get_$1() {
                return _$1;
            }

            public void set_$1(int _$1) {
                this._$1 = _$1;
            }

            public int get_$11() {
                return _$11;
            }

            public void set_$11(int _$11) {
                this._$11 = _$11;
            }

            public int get_$119() {
                return _$119;
            }

            public void set_$119(int _$119) {
                this._$119 = _$119;
            }

            public int get_$129() {
                return _$129;
            }

            public void set_$129(int _$129) {
                this._$129 = _$129;
            }

            public int get_$13() {
                return _$13;
            }

            public void set_$13(int _$13) {
                this._$13 = _$13;
            }

            public int get_$138() {
                return _$138;
            }

            public void set_$138(int _$138) {
                this._$138 = _$138;
            }

            public int get_$155() {
                return _$155;
            }

            public void set_$155(int _$155) {
                this._$155 = _$155;
            }

            public int get_$160() {
                return _$160;
            }

            public void set_$160(int _$160) {
                this._$160 = _$160;
            }

            public int get_$165() {
                return _$165;
            }

            public void set_$165(int _$165) {
                this._$165 = _$165;
            }

            public int get_$167() {
                return _$167;
            }

            public void set_$167(int _$167) {
                this._$167 = _$167;
            }

            public int get_$17() {
                return _$17;
            }

            public void set_$17(int _$17) {
                this._$17 = _$17;
            }

            public int get_$177() {
                return _$177;
            }

            public void set_$177(int _$177) {
                this._$177 = _$177;
            }

            public int get_$181() {
                return _$181;
            }

            public void set_$181(int _$181) {
                this._$181 = _$181;
            }

            public int get_$188() {
                return _$188;
            }

            public void set_$188(int _$188) {
                this._$188 = _$188;
            }

            public int get_$202() {
                return _$202;
            }

            public void set_$202(int _$202) {
                this._$202 = _$202;
            }

            public int get_$23() {
                return _$23;
            }

            public void set_$23(int _$23) {
                this._$23 = _$23;
            }

            public int get_$3() {
                return _$3;
            }

            public void set_$3(int _$3) {
                this._$3 = _$3;
            }

            public int get_$36() {
                return _$36;
            }

            public void set_$36(int _$36) {
                this._$36 = _$36;
            }

            public int get_$4() {
                return _$4;
            }

            public void set_$4(int _$4) {
                this._$4 = _$4;
            }

            public int get_$5() {
                return _$5;
            }

            public void set_$5(int _$5) {
                this._$5 = _$5;
            }

            public int get_$75() {
                return _$75;
            }

            public void set_$75(int _$75) {
                this._$75 = _$75;
            }

            public int get_$76() {
                return _$76;
            }

            public void set_$76(int _$76) {
                this._$76 = _$76;
            }
        }
    }
}
