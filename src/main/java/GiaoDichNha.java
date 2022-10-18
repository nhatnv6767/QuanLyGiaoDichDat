public class GiaoDichNha extends GiaoDich {
    private LoaiNha loaiNha;
    private String diaChi;

    public GiaoDichNha(int id, String date, double donGia, double dienTich, LoaiNha loaiNha, String diaChi) {
        super(id, date, donGia, dienTich);
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    public LoaiNha getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(LoaiNha loaiNha) {
        this.loaiNha = loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    // calculate home price
    public double getPrice() {
        if (loaiNha == LoaiNha.LOAI_THUONG) {
            return super.getPrice() * 0.9;
        }
        return super.getPrice();
    }

    public static GiaoDichNha nhapGiaoDichNha(int id) {
        String date = Nhap.inputDate();
        double donGia = Nhap.inputDouble("Nhập vào đơn giá: ");
        double dienTich = Nhap.inputDouble("Nhập vào diện tích: ");
        String diaChi = Nhap.inputString("Nhập vào địa chỉ: ");

        System.out.println("Nhập vào loại nhà: ");
        System.out.println("1. Loại thường");
        System.out.println("2. Loại đặc biệt");
        int choice = Nhap.inputInt("Mời chọn (mặc định: Loại thường): ");
        switch (choice) {
            case 2:
                return new GiaoDichNha(id, date, donGia, dienTich, LoaiNha.LOAI_CAO_CAP, diaChi);
            default:
                return new GiaoDichNha(id, date, donGia, dienTich, LoaiNha.LOAI_THUONG, diaChi);
        }
    }

    @Override
    public String toString() {
        return String.format("%s%15s%15s%15s%15s%15s",
                super.getId(),
                super.getDate(),
                Nhap.toVnd(getPrice()),
                super.getDienTich(),
                loaiNha.toString(),
                diaChi
        );
    }
}
