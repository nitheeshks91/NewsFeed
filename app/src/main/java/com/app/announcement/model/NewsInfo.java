package com.app.announcement.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by nitheesh on 24/4/18
 */

public class NewsInfo implements Serializable {

    @SerializedName("ID")
    private Properties id;

    @SerializedName("NATIVE_DATE")
    private Properties nativeDate;

    @SerializedName("ANNOUNCEMENT_DATE")
    private Properties announcementDate;

    @SerializedName("ANNOUNCEMENT_TITLE")
    private Properties announcementTitle;

    @SerializedName("ANNOUNCEMENT_IMAGE")
    private Properties announcementImage;

    @SerializedName("ANNOUNCEMENT_IMAGE_THUMBNAIL")
    private Properties announcementImageThumbnail;

    @SerializedName("ANNOUNCEMENT_HTML")
    private Properties announcementHtml;

    public Properties getAnnouncementImage() {
        return announcementImage;
    }

    public Properties getAnnouncementImageThumbnail() {
        return announcementImageThumbnail;
    }

    public Properties getAnnouncementTitle() {
        return announcementTitle;
    }

    public Properties getAnnouncementDate() {
        return announcementDate;
    }

    public Properties getAnnouncementHtml() {
        return announcementHtml;
    }

    public class Properties implements Serializable {
        @SerializedName("Tag")
        private String tag;
        @SerializedName("TypeCode")
        private int typeCode;
        @SerializedName("Value")
        private String value;
        @SerializedName("IsBinaryUnique")
        private boolean isBinaryUnique;

        public String getValue() {
            return value;
        }
    }
}
