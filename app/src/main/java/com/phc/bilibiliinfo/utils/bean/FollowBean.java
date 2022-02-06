package com.phc.bilibiliinfo.utils.bean;

public class FollowBean {

    private Integer code;
    private String message;
    private Integer ttl;
    private DataDTO data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        private Integer mid;
        private Integer following;
        private Integer whisper;
        private Integer black;
        private Integer follower;

        public Integer getMid() {
            return mid;
        }

        public void setMid(Integer mid) {
            this.mid = mid;
        }

        public Integer getFollowing() {
            return following;
        }

        public void setFollowing(Integer following) {
            this.following = following;
        }

        public Integer getWhisper() {
            return whisper;
        }

        public void setWhisper(Integer whisper) {
            this.whisper = whisper;
        }

        public Integer getBlack() {
            return black;
        }

        public void setBlack(Integer black) {
            this.black = black;
        }

        public Integer getFollower() {
            return follower;
        }

        public void setFollower(Integer follower) {
            this.follower = follower;
        }
    }
}
