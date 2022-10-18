/*
 * Mục đích: Tạo lớp Giao Dich, chứa các para chung cho giao dịch đất và giao dịch nhà
 * Người tạo: Trần Thiện Tâm
 * Ngày tạo: 18/10/2022
 * Version: 1.0
 * */
public class GiaoDich {
    private int id;
    private String date;
    private double donGia;
    private double dienTich;

    public GiaoDich(int id, String date, double donGia, double dienTich) {
        this.id = id;
        this.date = date;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPrice() {
        return donGia * dienTich;
    }

    @Override
    public String toString() {
        return String.format("%s%15s%15s%15s", id, date, donGia, dienTich);
    }
}
