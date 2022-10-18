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
        switch (choice) {
            case 2:
                return new GiaoDichDat(id, date, donGia, dienTich, LoaiDat.LOAI_B);
            case 3:
                return new GiaoDichDat(id, date, donGia, dienTich, LoaiDat.LOAI_C);
            default:
                return new GiaoDichDat(id, date, donGia, dienTich, LoaiDat.LOAI_A);
        }
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
