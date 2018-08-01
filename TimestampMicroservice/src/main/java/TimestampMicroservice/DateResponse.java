package TimestampMicroservice;

public class DateResponse {

    long unix;
    String utc;

    public DateResponse(long unix, String utc) {
        this.unix = unix;
        this.utc = utc;
    }

    public DateResponse() {
    }

    public long getUnix() {
        return unix;
    }

    public void setUnix(long unix) {
        this.unix = unix;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }
}
