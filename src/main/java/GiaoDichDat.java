/*
 * Mục đích: Tạo lớp Giao Dich Đất, kế thừa từ lớp Giao dịch,
 * xử lý các nghiệp vụ liên quan đến giao dịch đất
 * Người tạo: Trần Thiện Tâm
 * Ngày tạo: 18/10/2022
 * Version: 1.0
 * */
public class GiaoDichDat extends GiaoDich {
    private LoaiDat loaiDat;

    public GiaoDichDat(int id, String date, double donGia, double dienTich, LoaiDat loaiDat) {
        super(id, date, donGia, dienTich);
        this.loaiDat = loaiDat;
    }

    public LoaiDat getLoaiDat() {
        return loaiDat;
    }

    public void setLoaiDat(LoaiDat loaiDat) {
        this.loaiDat = loaiDat;
    }

    // calculate soil price

    @Override
    public double getPrice() {
        if (loaiDat == LoaiDat.LOAI_A) {
            return super.getPrice() * 1.5;
        }
        return super.getPrice();
    }

    // thong tin ve dat
    public static GiaoDichDat nhapGiaoDichDat(int id) {
        String date = Nhap.inputDate();
        double donGia = Nhap.inputDouble("Nhập vào đơn giá: ");
        double dienTich = Nhap.inputDouble("Nhập vào diện tích: ");
        System.out.println("Nhập vào loại đất:");
        System.out.println("1. Loại A");
        System.out.println("2. Loại B");
        System.out.println("3. Loại C");
        int choice = Nhap.inputInt("Mời lựa chọn (mặc định: Loại A): ");
        return switch (choice) {
            case 2 -> new GiaoDichDat(id, date, donGia, dienTich, LoaiDat.LOAI_B);
            case 3 -> new GiaoDichDat(id, date, donGia, dienTich, LoaiDat.LOAI_C);
            default -> new GiaoDichDat(id, date, donGia, dienTich, LoaiDat.LOAI_A);
        };
    }

    @Override
    public String toString() {
        return String.format("%s%15s%15s%15s%15s",
                super.getId(),
                super.getDate(),
                Nhap.toVnd(getPrice()),
                super.getDienTich(),
                loaiDat.toString()
        );
    }
}
