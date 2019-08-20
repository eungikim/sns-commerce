package kr.eungikim.snscommerce.db.domain;

public class Friend {

    private String mImageUrl;
    private String mName;
    private String mStatusMsg;

    public Friend(String mName) {
        this.mName = mName;
    }

    public String getName() {
        return mName;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "mImageUrl='" + mImageUrl + '\'' +
                ", mName='" + mName + '\'' +
                ", mStatusMsg='" + mStatusMsg + '\'' +
                '}';
    }
}
