import java.util.ArrayList;

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
        System.out.println("************** Danh sách giao dịch đất **************");
        if (this.dsGiaoDichDat.size() == 0) {
            System.out.println("Hiện không có giao dịch nào cả!");
        }
        String tieuDe = String.format("%s%15s%15s%15s%15s", "ID", "Date", "Đơn giá", "Diện tích", "Loại Đất");
        System.out.println(tieuDe);
        for (GiaoDich giaodich : dsGiaoDichDat) {
            System.out.println(giaodich.toString());
        }
    }

    private void xuatDSGiaoDichNha() {
        System.out.println("************** Danh sách giao dịch nhà **************");
        if (this.dsGiaoDichNha.size() == 0) {
            System.out.println("Hiện không có giao dịch nào cả!");
        }
        String tieuDe = String.format("%s%15s%15s%15s%15s%15s", "ID", "Date", "Đơn giá", "Diện tích", "Loại nhà", "Địa chỉ");
        System.out.println(tieuDe);
        for (GiaoDich giaodich : dsGiaoDichNha) {
            System.out.println(giaodich.toString());
        }
    }

    // ds đất giao dịch trong 9/2003
    private void xuatDSGiaoDichDat(String Date) {
        System.out.println("************** Danh sách giao dịch đất (" + Date + ") **************");
        if (this.dsGiaoDichDat.size() == 0) {
            System.out.println("Hiện không có giao dịch nào cả!");
            return;
        }
        String tieuDe = String.format("%s%15s%15s%15s%15s", "ID", "Date", "Đơn giá", "Diện tích", "Loại Đất");
        System.out.println(tieuDe);
        for (GiaoDich giaodich : dsGiaoDichDat) {
            if (checkDate(giaodich.getDate(), Date)) {
                System.out.println(giaodich.toString());
            }
        }

    }

    // ds nhà giao dịch trong 9/2003
    private void xuatDSGiaoDichNha(String Date) {
        System.out.println("************** Danh sách giao dịch nhà (" + Date + ") **************");
        if (this.dsGiaoDichNha.size() == 0) {
            System.out.println("Hiện không có giao dịch nào cả!");
            return;
        }
        String tieuDe = String.format("%s%15s%15s%15s%15s%15s", "ID", "Date", "Đơn giá", "Diện tích", "Loại nhà", "Địa chỉ");
        System.out.println(tieuDe);
        for (GiaoDich giaodich : dsGiaoDichNha) {
            if (checkDate(giaodich.getDate(), Date)) {
                System.out.println(giaodich.toString());
            }
        }

    }

    // trung binh tien gd dat
    private double trungBinhGiaoDichDat() {
        double sum = 0;
        for (GiaoDich giaodich : dsGiaoDichDat) {
            sum += giaodich.getPrice();
        }
        return sum / dsGiaoDichDat.size();
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

    private void menuChinh() {
        while (true) {
            System.out.println("1. Thêm giao dịch");
            System.out.println("2. Xuất danh sách giao dịch");
            System.out.println("3. Xuất số lượng giao dịch đất và nhà");
            System.out.println("4. Trung bình (tiền) của giao dịch đất");
            System.out.println("5. Hiển thị giao dịch trong tháng 9/2013");
            System.out.println("6. Thoát");
            int choice = Nhap.inputInt("Mời lựa chọn: ");
            menuChinh(choice);
        }
    }

    private void menuChinh(int choice) {
        int tempChoice = 0;
        switch (choice) {
            case 1:
                menuPhu(choice);
                tempChoice = Nhap.inputInt("Mời lựa chọn: ");
                if (tempChoice == 1) { // giao dịch đất
                    // id sẽ được thêm tự động, bắt đầu từ 1, size == 0   (+ 1 = 1)
                    GiaoDichDat gd = GiaoDichDat.nhapGiaoDichDat(dsGiaoDichDat.size() + 1);
                    themGiaoDichDat(gd);
                } else if (tempChoice == 2) { // giao dịch nhà
                    GiaoDichNha gd = GiaoDichNha.nhapGiaoDichNha(dsGiaoDichNha.size() + 1);
                    themGiaoDichNha(gd);
                }
                break;

            case 2:
                menuPhu(choice);
                tempChoice = Nhap.inputInt("Mời lựa chọn: ");
                if (tempChoice == 1) {
                    xuatDSGiaoDichDat();
                } else if (tempChoice == 2) {
                    xuatDSGiaoDichNha();
                }
                break;

            case 3:
                System.out.println("Số lượng giao dịch đất: " + dsGiaoDichDat.size());
                System.out.println("Số lượng giao dịch nhà: " + dsGiaoDichNha.size());
                break;

            case 4:
                System.out.println("Trung bình (tiền) của giao dịch đất: " + trungBinhGiaoDichDat());
                break;

            case 5:
                xuatDSGiaoDichDat("2013/09");
                xuatDSGiaoDichNha("2013/09");
                break;

            case 6:
                System.exit(0);
                break;
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


}
