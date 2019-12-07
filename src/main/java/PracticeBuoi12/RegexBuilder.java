package PracticeBuoi12;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBuilder {

    private static final String LOG_PATH = "E:\\java-core-c4\\buoi12\\logfile.txt";

    private static final String THONG_TIN_CHUNG_PATTERN = "\\{THONG_TIN_CHUNGNGAY_NHAP_HANG: (.*?)TEN_CONG_TY: (.*?)}THONG_TIN_CHUNG((?:\\{DANH_MUC.*?}DANH_MUC)+)";
    private static final String DANH_MUC_PATTERN = "\\{DANH_MUCID_DM: (.*?)TEN_DM: (.*?)((?:\\{SAN_PHAM.*?}SAN_PHAM)+)}DANH_MUC";
    private static final String SAN_PHAM_PATTERN = "\\{SAN_PHAMID_SP: (.*?)TEN_SP: (.*?)GIA_SP: (.*?)SL_SP: (.*?)}SAN_PHAM";
    private static final String ID_SP_PATTERN = "^[A-Z]{2}\\d{3}$";

    public ArrayList<SanPham> getSanPhamsFromDataFile (String dataFromFile) throws IOException {
        String idSP;
        String tenSP;
        double giaSP;
        int soLuongSP;
        String idDanhMuc;
        String tenDanhMuc;
        Date ngayNhapHang;
        String tenCongTy;

        ArrayList<SanPham> sanPhams = new ArrayList<>();

        Pattern thongTinChungPattern = Pattern.compile(THONG_TIN_CHUNG_PATTERN);
        Matcher thongTinChungMatcher = thongTinChungPattern.matcher(dataFromFile);
        while (thongTinChungMatcher.find()) {
            ngayNhapHang = xulyDate(thongTinChungMatcher.group(1));
            tenCongTy = thongTinChungMatcher.group(2);

            Pattern danhMucPattern = Pattern.compile(DANH_MUC_PATTERN);
            Matcher danhMucMatcher = danhMucPattern.matcher(thongTinChungMatcher.group(3));
            while (danhMucMatcher.find()) {
                idDanhMuc = danhMucMatcher.group(1);
                tenDanhMuc = danhMucMatcher.group(2);

                Pattern sanPhamPattern = Pattern.compile(SAN_PHAM_PATTERN);
                Matcher sanPhamMatcher = sanPhamPattern.matcher(danhMucMatcher.group(3));
                while (sanPhamMatcher.find()) {
                    idSP = sanPhamMatcher.group(1);
                    tenSP = sanPhamMatcher.group(2);
                    giaSP = Double.valueOf(sanPhamMatcher.group(3).replace(",", ""));
                    soLuongSP = Integer.parseInt(sanPhamMatcher.group(4));

                    if (checkIdSPSystax(idSP)){
                        SanPham sp = new SanPham(idSP, tenSP, giaSP, soLuongSP, idDanhMuc, tenDanhMuc, tenCongTy, ngayNhapHang);
                        sanPhams.add(sp);
                    } else {
                        IFileController i = new FileController();
                        SanPham sp = new SanPham(idSP, tenSP, giaSP, soLuongSP, idDanhMuc, tenDanhMuc, tenCongTy, ngayNhapHang);
                        i.setDataToFile(LOG_PATH, sp.toString());
                    }

                }
            }
        }

        return sanPhams;
    }

    public ArrayList<String> getTenDanhMucsFromDataFile (String dataFromFile) throws IOException {

        ArrayList<String> tenDanhMucs = new ArrayList<>();

        Pattern danhMucPattern = Pattern.compile(DANH_MUC_PATTERN);
        Matcher danhMucMatcher = danhMucPattern.matcher(dataFromFile);
        while (danhMucMatcher.find()) {
            tenDanhMucs.add(danhMucMatcher.group(2));
        }
        return tenDanhMucs;
    }

    private static Date xulyDate (String Date) {
        Date d = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            d = sdf.parse(Date);
        }catch (Exception e){
            System.out.println("convert String to Date ERROR!!!");
        }
        return d;
    }

    private boolean checkIdSPSystax(String idSP){
        Pattern idSPPattern = Pattern.compile(ID_SP_PATTERN);
        Matcher idSPMatcher = idSPPattern.matcher(idSP);
        boolean b = idSPMatcher.matches();
        return b;
    }
}
