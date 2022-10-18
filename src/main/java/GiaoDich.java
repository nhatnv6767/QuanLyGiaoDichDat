public class GiaoDich {
    private String id;
    private String date;
    private double donGia;
    private double dienTich;

    public GiaoDich(String id, String date, double donGia, double dienTich) {
        this.id = id;
        this.date = date;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    @Override
    public String toString() {
        return String.format("%s%15s%15s%15s", id, date, donGia, dienTich);
    }
}
