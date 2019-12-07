package PracticeBuoi12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String FILE_PATH = "E:\\java-core-c4\\buoi12\\DATA_FILE.txt";

    public static void main(String[] args) {
        IFileController i = new FileController();
        RegexBuilder regexBuilder = new RegexBuilder();
        ISanPhamController iSanPhamController = new SanPhamController();

        ArrayList<SanPham> sanPhams = new ArrayList<>();
        ArrayList<String> tenDanhMucs = new ArrayList<>();
        System.out.println("a. Xu ly du lieu E:\\java-core-c4\\buoi12\\DATA_FILE.txt");
        try {
            String data = i.getDataFromFile(FILE_PATH);

            sanPhams = regexBuilder.getSanPhamsFromDataFile(data);
            tenDanhMucs = regexBuilder.getTenDanhMucsFromDataFile(data);

            System.out.println(">>>>> Successfull!!");
            iSanPhamController.getSanPhams(sanPhams);

        }catch (IOException e){
            System.out.println("File error!!!!");
        }

        int flag = 1;
        while(flag == 1) {
            System.out.println("b. Nhap danh muc muon tinh tong san pham: ");

            System.out.println("Nhap ten danh muc can tinh gia: ");

            Scanner sc = new Scanner(System.in);
            String danhMucValueFromConsole = sc.nextLine();

            String closestDanhMucValue = iSanPhamController.findClosestDanhMucValue(danhMucValueFromConsole, tenDanhMucs);

            System.out.println("Tong gia tri san pham theo closestDanhMucValue : " + closestDanhMucValue + " la: ");
            iSanPhamController.inRaSumGiaTriSanPhamTheoDanhMuc(sanPhams, closestDanhMucValue);

            System.out.println("Chon 1: tiep tuc, 0: thoat: ");
            flag = sc.nextInt();
            sc.nextLine();
        }

        int flag1 = 1;
        while(flag1 == 1) {
            System.out.println("c. Nhap ma san pham: ");

            Scanner sc = new Scanner(System.in);
            String maSanPham = sc.nextLine();

            iSanPhamController.inRaThongTinSanPhamTheoMaSanPham(sanPhams, maSanPham);

            System.out.println("Chon 1: tiep tuc, 0: thoat: ");
            flag1 = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("d. Sap xe sanPhams theo gia tri sp (dung QuickSort): ");
        ArrayList<SanPham> sanPhams1 = (ArrayList<SanPham>) sanPhams.clone();
        iSanPhamController.sapXepDanhSachSanPhamTheoGiaSanPham(sanPhams1, 0, sanPhams.size() -1);
        iSanPhamController.getSanPhams(sanPhams1);
    }

}
