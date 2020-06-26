package com.robotemi.sdk.notification;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

public class NormalNotification implements Notification, Parcelable {

    public static final Parcelable.Creator<NormalNotification> CREATOR = new Parcelable.Creator<NormalNotification>() {
        @Override
        public NormalNotification createFromParcel(Parcel source) {
            return new NormalNotification(source);
        }

        @Override
        public NormalNotification[] newArray(int size) {
            return new NormalNotification[size];
        }
    };

    private String notificationId;

    private Notification.Type type;

    private String title; // Required

    @StringRes
    private int titleResource;

    private String subtitle;

    @StringRes
    private int subtitleResource;

    @DrawableRes
    private int iconResource;

    private Bitmap bitmap;

    private NormalNotification(NormalNotification.Builder builder) {
        this.type = builder.type == null ? Type.INFO : builder.type;
        this.title = builder.title;
        this.titleResource = builder.titleResource;
        this.subtitle = builder.subtitle;
        this.subtitleResource = builder.subtitleResource;
        this.iconResource = builder.iconResource;
        this.bitmap = builder.bitmap;
        this.notificationId = UUID.randomUUID().toString();
    }

    protected NormalNotification(Parcel in) {
        int tmpType = in.readInt();
        this.type = tmpType == -1 ? null : Type.values()[tmpType];
        this.title = in.readString();
        this.titleResource = in.readInt();
        this.subtitle = in.readString();
        this.subtitleResource = in.readInt();
        this.iconResource = in.readInt();
        this.bitmap = in.readParcelable(getClass().getClassLoader());
    }

    public static NormalNotification.Builder builder(String title) {
        return new NormalNotification.Builder(title);
    }

    @Override
    public String getNotificationId() {
        return notificationId;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public int getTitleResource() {
        return titleResource;
    }

    @Override
    public int getSubtitleResource() {
        return subtitleResource;
    }

    @Override
    public int getIconResource() {
        return iconResource;
    }

    @Nullable
    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type == null ? -1 : this.type.ordinal());
        dest.writeString(this.title);
        dest.writeInt(this.titleResource);
        dest.writeString(this.subtitle);
        dest.writeInt(this.subtitleResource);
        dest.writeInt(this.iconResource);
        dest.writeParcelable(this.bitmap, flags);
    }

    public static class Builder {

        public Notification.Type type;

        public String title;

        public @StringRes
        int titleResource;

        public String subtitle;

        public @StringRes
        int subtitleResource;

        public @DrawableRes
        int iconResource;

        public Bitmap bitmap;

        public Builder(String title) {
            this.title = title;
        }

        public NormalNotification.Builder type(Notification.Type type) {
            this.type = type;
            return this;
        }

        public NormalNotification.Builder title(String title) {
            this.title = title;
            return this;
        }

        public NormalNotification.Builder titleResource(@StringRes int titleResource) {
            this.titleResource = titleResource;
            return this;
        }

        public NormalNotification.Builder subtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public NormalNotification.Builder subtitleResource(@StringRes int subtitleResource) {
            this.subtitleResource = subtitleResource;
            return this;
        }

        public NormalNotification.Builder iconResource(@DrawableRes int iconResource) {
            this.iconResource = iconResource;
            return this;
        }

        public NormalNotification.Builder bitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }


        public NormalNotification build() {
            return new NormalNotification(this);
        }
    }
}
