import java.util.ArrayList;

/*
 * Mục đích: Quản lý chung các loại giao dịch, bằng danh sách
 * Người tạo: Trần Thiện Tâm
 * Ngày tạo: 18/10/2022
 * Version: 1.0
 * */


public class QuanLyGiaoDich {
    // danh sach chua cac giao dich
    private ArrayList<GiaoDich> dsGiaoDichDat = new ArrayList<>();
    private ArrayList<GiaoDich> dsGiaoDichNha = new ArrayList<>();

    // dùng để thêm giao dịch đất vào danh sách
    private void themGiaoDichDat(GiaoDichDat gd) {
        dsGiaoDichDat.add(gd);
    }

    // dùng để thêm giao dịch nhà vào danh sách
    private void themGiaoDichNha(GiaoDichNha gd) {
        dsGiaoDichNha.add(gd);
    }

    private void xuatDSGiaoDichDat() {
        System.out.println("\n************** Danh sách giao dịch đất **************");
        if (this.dsGiaoDichDat.size() == 0) {
            System.out.println("Hiện không có giao dịch nào cả!");
            System.out.println("********************* Kết thúc *********************\n");
        }
        String tieuDe = String.format("%s%15s%15s%15s%15s", "ID", "Date", "Đơn giá", "Diện tích", "Loại Đất");
        System.out.println(tieuDe);
        for (GiaoDich giaodich : dsGiaoDichDat) {
            System.out.println(giaodich.toString());
        }
        System.out.println("********************* Kết thúc *********************\n");
    }

    private void xuatDSGiaoDichNha() {
        System.out.println("\n************** Danh sách giao dịch nhà **************");
        if (this.dsGiaoDichNha.size() == 0) {
            System.out.println("Hiện không có giao dịch nào cả!");
            System.out.println("********************* Kết thúc *********************\n");
        }
        String tieuDe = String.format("%s%15s%15s%15s%15s%15s", "ID", "Date", "Đơn giá", "Diện tích", "Loại nhà", "Địa chỉ");
        System.out.println(tieuDe);
        for (GiaoDich giaodich : dsGiaoDichNha) {
            System.out.println(giaodich.toString());
        }
        System.out.println("********************* Kết thúc *********************\n");
    }

    // ds đất giao dịch trong 9/2003
    private void xuatDSGiaoDichDat(String Date) {
        System.out.println("\n************** Danh sách giao dịch đất (" + Date + ") **************");
        if (this.dsGiaoDichDat.size() == 0) {
            System.out.println("Hiện không có giao dịch nào cả!");
            System.out.println("************************** Kết thúc **************************\n");
            return;
        }
        String tieuDe = String.format("%s%15s%15s%15s%15s", "ID", "Date", "Đơn giá", "Diện tích", "Loại Đất");
        System.out.println(tieuDe);
        for (GiaoDich giaodich : dsGiaoDichDat) {
            if (checkDate(giaodich.getDate(), Date)) {
                System.out.println(giaodich.toString());
            }
        }

        System.out.println("************************** Kết thúc **************************\n");

    }

    // ds nhà giao dịch trong 9/2003
    private void xuatDSGiaoDichNha(String Date) {
        System.out.println("\n************** Danh sách giao dịch nhà (" + Date + ") **************");
        if (this.dsGiaoDichNha.size() == 0) {
            System.out.println("Hiện không có giao dịch nào cả!");
            System.out.println("************************** Kết thúc **************************\n");
            return;
        }
        String tieuDe = String.format("%s%15s%15s%15s%15s%15s", "ID", "Date", "Đơn giá", "Diện tích", "Loại nhà", "Địa chỉ");
        System.out.println(tieuDe);
        for (GiaoDich giaodich : dsGiaoDichNha) {
            if (checkDate(giaodich.getDate(), Date)) {
                System.out.println(giaodich.toString());
            }
        }

        System.out.println("************************** Kết thúc **************************\n");

    }

    // trung binh tien gd dat
    private String trungBinhGiaoDichDat() {
        double sum = 0;
        for (GiaoDich giaodich : dsGiaoDichDat) {
            sum += giaodich.getPrice();
        }

        String tbinhGDDat = Nhap.toVnd(sum / dsGiaoDichDat.size());
        return tbinhGDDat;
    }

    // kiểm tra ngay giao dich và ngày cần kiểm tra (9/2003)
    private boolean checkDate(String Date1, String Date2) {
        // phân tách chuỗi bởi dấu /
        // lúc nhập data có dạng yyyy/MM/dd nên sau khi tách ta có [0]: yyyy, [1]: MM, [2]:dd
        // so sánh [0] là năm và [1] là tháng
        String[] date1 = Date1.split("/");
        String[] date2 = Date2.split("/");

        // lấy năm và tháng của Date1
        int year1 = Integer.parseInt(date1[0]);
        int month1 = Integer.parseInt(date1[1]);
        // lấy năm và tháng của Date2
        int year2 = Integer.parseInt(date2[0]);
        int month2 = Integer.parseInt(date2[1]);

        // trả về true nếu hai giá trị đưa vào có tháng và năm trùng nhau ( bằng nhau)
        return (year1 == year2 && month1 == month2);
    }

    public void menuChinh() {
        while (true) {
            System.out.println("\n------- Chương trình quản lý giao dịch đất và nhà -------");
            System.out.println("1. Thêm giao dịch (Thêm bằng tay)");
            System.out.println("2. Xuất danh sách giao dịch");
            System.out.println("3. Xuất số lượng giao dịch đất và nhà");
            System.out.println("4. Trung bình (tiền) của giao dịch đất");
            System.out.println("5. Hiển thị giao dịch trong tháng 9/2013");
            System.out.println("6. Thêm giao dịch bằng Dummy Data (Both)");
            System.out.println("7. Thoát");
            System.out.println("---------------------------------------------------------");
            int choice = Nhap.inputInt("Mời lựa chọn: ");
            menuChinh(choice);
        }
    }

    private void menuChinh(int choice) {
        int tempChoice = 0;
        switch (choice) {
            case 1 -> {
                menuPhu(choice);
                tempChoice = Nhap.inputInt("Mời lựa chọn: ");
                if (tempChoice == 1) { // giao dịch đất
                    // id sẽ được thêm tự động, bắt đầu từ 1 nếu chưa có phần tử nào, size == 0   (+ 1 = 1)
                    GiaoDichDat gd = GiaoDichDat.nhapGiaoDichDat(dsGiaoDichDat.size() + 1);
                    themGiaoDichDat(gd);
                } else if (tempChoice == 2) { // giao dịch nhà
                    GiaoDichNha gd = GiaoDichNha.nhapGiaoDichNha(dsGiaoDichNha.size() + 1);
                    themGiaoDichNha(gd);
                }
            }
            case 2 -> {
                menuPhu(choice);
                tempChoice = Nhap.inputInt("Mời lựa chọn: ");
                if (tempChoice == 1) {
                    xuatDSGiaoDichDat();
                } else if (tempChoice == 2) {
                    xuatDSGiaoDichNha();
                }
            }
            case 3 -> {
                System.out.println("\n***************** Số lượng giao dịch *****************");
                System.out.println("Giao dịch đất: " + dsGiaoDichDat.size());
                System.out.println("Giao dịch nhà: " + dsGiaoDichNha.size());
                System.out.println("********************** Kết thúc **********************\n");
            }
            case 4 -> {
                String tbGiaoDichDat = dsGiaoDichDat.size() == 0 ? "0" : trungBinhGiaoDichDat();
                System.out.println("\n***************** Trung Bình *****************");
                System.out.println("Trung bình (tiền) của giao dịch đất: " + tbGiaoDichDat);
                System.out.println("********************** Kết thúc **********************\n");
            }
            case 5 -> {
                xuatDSGiaoDichDat("2013/09");
                xuatDSGiaoDichNha("2013/09");
            }
            case 6 -> {
                dummyDataGDDat();
                dummyDataGDNha();
                System.out.println("\n******************************** THÔNG BÁO ********************************");
                System.out.println("ĐÃ THÊM THÀNH CÔNG BẰNG DUMMY DATA, CHỌN XUẤT DANH SÁCH ĐỂ XEM DS VỪA THÊM. \n");
            }
            case 7 -> System.exit(0);
        }
    }

    private void menuPhu(int choice) {
        if (choice == 1) {
            System.out.println("1. Thêm giao dịch đất");
            System.out.println("2. Thêm giao dịch nhà");
        } else if (choice == 2) {
            System.out.println("1. Xuất giao dịch đất");
            System.out.println("2. Xuất giao dịch nhà");
        }
    }

    private void dummyDataGDDat() {
        GiaoDichDat gdd1 = new GiaoDichDat(111, "2013/09/12", 3000000, 30, LoaiDat.LOAI_A);
        dsGiaoDichDat.add(gdd1);

        GiaoDichDat gdd2 = new GiaoDichDat(112, "2018/09/12", 3000000, 45, LoaiDat.LOAI_B);
        dsGiaoDichDat.add(gdd2);

        GiaoDichDat gdd3 = new GiaoDichDat(113, "2013/09/10", 3000000, 15, LoaiDat.LOAI_C);
        dsGiaoDichDat.add(gdd3);

        GiaoDichDat gdd4 = new GiaoDichDat(114, "2015/09/12", 3000000, 20, LoaiDat.LOAI_A);
        dsGiaoDichDat.add(gdd4);

        GiaoDichDat gdd5 = new GiaoDichDat(115, "2008/09/12", 3000000, 25, LoaiDat.LOAI_A);
        dsGiaoDichDat.add(gdd5);

        GiaoDichDat gdd6 = new GiaoDichDat(116, "2015/09/12", 3000000, 70, LoaiDat.LOAI_B);
        dsGiaoDichDat.add(gdd6);

        GiaoDichDat gdd7 = new GiaoDichDat(117, "2007/01/02", 7000000, 300, LoaiDat.LOAI_B);
        dsGiaoDichDat.add(gdd7);

        GiaoDichDat gdd8 = new GiaoDichDat(118, "2012/09/12", 4000000, 500, LoaiDat.LOAI_A);
        dsGiaoDichDat.add(gdd8);

        GiaoDichDat gdd9 = new GiaoDichDat(119, "2013/09/05", 2000000, 120, LoaiDat.LOAI_A);
        dsGiaoDichDat.add(gdd9);

        GiaoDichDat gdd10 = new GiaoDichDat(120, "2013/09/06", 400000, 700, LoaiDat.LOAI_B);
        dsGiaoDichDat.add(gdd10);
    }

    private void dummyDataGDNha() {
        GiaoDichNha gdn1 = new GiaoDichNha(211, "2013/09/08", 1500000, 50, LoaiNha.LOAI_THUONG, "Địa chỉ 1");
        dsGiaoDichNha.add(gdn1);

        GiaoDichNha gdn2 = new GiaoDichNha(212, "2013/09/08", 2300000, 300, LoaiNha.LOAI_CAO_CAP, "Địa chỉ 2");
        dsGiaoDichNha.add(gdn2);

        GiaoDichNha gdn3 = new GiaoDichNha(213, "2015/09/08", 4000000, 45, LoaiNha.LOAI_THUONG, "Địa chỉ 3");
        dsGiaoDichNha.add(gdn3);

        GiaoDichNha gdn4 = new GiaoDichNha(214, "2013/09/08", 1500000, 70, LoaiNha.LOAI_THUONG, "Địa chỉ 4");
        dsGiaoDichNha.add(gdn4);

        GiaoDichNha gdn5 = new GiaoDichNha(215, "2011/09/08", 1450000, 25, LoaiNha.LOAI_CAO_CAP, "Địa chỉ 5");
        dsGiaoDichNha.add(gdn5);

        GiaoDichNha gdn6 = new GiaoDichNha(216, "2010/09/08", 1700000, 15, LoaiNha.LOAI_THUONG, "Địa chỉ 6");
        dsGiaoDichNha.add(gdn6);

        GiaoDichNha gdn7 = new GiaoDichNha(217, "2013/09/08", 3500000, 25, LoaiNha.LOAI_CAO_CAP, "Địa chỉ 7");
        dsGiaoDichNha.add(gdn7);

        GiaoDichNha gdn8 = new GiaoDichNha(218, "2013/09/08", 3200000, 19, LoaiNha.LOAI_CAO_CAP, "Địa chỉ 8");
        dsGiaoDichNha.add(gdn8);

        GiaoDichNha gdn9 = new GiaoDichNha(219, "2012/09/08", 1200000, 90, LoaiNha.LOAI_THUONG, "Địa chỉ 9");
        dsGiaoDichNha.add(gdn9);

        GiaoDichNha gdn10 = new GiaoDichNha(220, "2011/09/08", 7500000, 25, LoaiNha.LOAI_CAO_CAP, "Địa chỉ 10");
        dsGiaoDichNha.add(gdn10);
    }


}
