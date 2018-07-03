package com.jinhua.toutiaonews.net.retrofit;

public class RetrofitConfig {
    private String mBaseUrl;
    private int mConnectionTimeout;
    private int mReadTimeout;
    private int mWriteTimeout;

    public RetrofitConfig(Builder builder) {
        this.mBaseUrl = builder.mBaseUrl;
        this.mConnectionTimeout = builder.mConnectionTimeout;
        this.mReadTimeout = builder.mReadTimeout;
        this.mWriteTimeout = builder.mWriteTimeout;
    }

    public String getBaseUrl() {
        return mBaseUrl;
    }

    public int getConnectionTimeout() {
        return mConnectionTimeout;
    }

    public int getReadTimeout() {
        return mReadTimeout;
    }

    public int getWriteTimeout() {
        return mWriteTimeout;
    }


    public static class Builder{
        private String mBaseUrl;
        private int mConnectionTimeout;
        private int mReadTimeout;
        private int mWriteTimeout;

        public Builder(){

        }

        public Builder setBaseUrl(String baseUrl){
            this.mBaseUrl = baseUrl;
            return this;
        }

        public Builder setConnectionTimeout(int connectionTimeout){
            this.mConnectionTimeout = connectionTimeout;
            return this;
        }

        public Builder setReadTimeout(int readTimeout){
            this.mReadTimeout = readTimeout;
            return this;
        }

        public Builder setWriteTimeout(int writeTimeout){
            this.mWriteTimeout = writeTimeout;
            return this;
        }

        public RetrofitConfig build(){
            return new RetrofitConfig(this);
        }
    }
}
