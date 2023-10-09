package Exam_Advance;

import java.util.Arrays;
import java.util.Scanner;

public class MusicManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Singer[] singers = new Singer[100];
        int singerIndex = 0;
        Song[] songs = new Song[100];
        int songIndex = 0;
        int choice;
        boolean check;

        do {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("**********************SINGER-MANAGEMENT*************************");
                    System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới (có validate dữ liệu nhập vào)");
                    System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
                    System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
                    System.out.println("4. Xóa ca sĩ theo mã id");
                    System.out.println("5. Thoát");
                    System.out.print("Chọn: ");
                    int singersChoice = Integer.parseInt(scanner.nextLine());

                    switch (singersChoice) {
                        case 1:
                            // Thêm mới ca sĩ
                            if (singerIndex < singers.length) {
                                singers[singerIndex] = new Singer();
                                singers[singerIndex].inputData();
                                System.out.println("Thêm mới thành công");
                                singerIndex++;
                            } else {
                                System.out.println("Danh sách ca sĩ đã đầy, không thể thêm nữa.");
                            }
                            break;
                        case 2:
                            System.out.println("Danh sách tất cả ca sĩ đã lưu trữ:");
                            for (int i = 0; i < singerIndex; i++) {
                                singers[i].DisplayData();
                            }
                            break;
                        case 3:
                            // Thay đổi thông tin ca sĩ theo mã id
                            System.out.print("Nhập id để thay đổi thông tin của ca sĩ: ");
                            int idEdit = Integer.parseInt(scanner.nextLine());
                            int indexEdit = findSingerIndexById(singers, singerIndex, idEdit);
                            if (indexEdit != -1) {
                                singers[indexEdit].inputData();
                                System.out.println("Cập nhật thành công");
                            } else {
                                System.out.println("Không tìm thấy thông tin ca sĩ có id " + idEdit);
                            }
                            break;
                        case 4:
                            // Xóa ca sĩ
                            System.out.print("Nhập id để xóa ca sĩ: ");
                            int idDelete = Integer.parseInt(scanner.nextLine());
                            int indexDelete = findSingerIndexById(singers, singerIndex, idDelete);
                            if (indexDelete != -1) {
                                if (!isSingerHasSong(songs, songIndex, idDelete)) {
                                    deleteSinger(singers, singerIndex, indexDelete);
                                    System.out.println("Xóa thành công");
                                    singerIndex--;
                                } else {
                                    System.out.println("Ca sĩ có bài hát không thể xóa.");
                                }
                            } else {
                                System.out.println("Không tìm thấy ca sĩ có id " + idDelete);
                            }
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    }
                    break;
                case 2:
                    System.out.println("""
                            **********************SONG-MANAGEMENT*************************
                            1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới (có validate dữ
                            liệu nhập vào)
                            2.Hiển thị danh sách tất cả bài hát đã lưu trữ
                            3.Thay đổi thông tin bài hát theo mã id
                            4.Xóa bài hát theo mã id
                            5.Thoát
                                                        
                            """);
                    int chose = Integer.parseInt(scanner.nextLine());
                    switch (chose) {
                        case 1:
                            //them moi bai hat
                            songs[songIndex] = new Song();
                            songs[songIndex++].inputData(singers, singerIndex);
                            System.out.println("them moi thanh cong");
                            break;
                        case 2:
                            //hien thi tat ca bai hat da luu tru
                            System.out.println("danh sach mon hoc");
                            for (int i = 0; i < songIndex; i++) {
                                songs[i].displayData();
                            }
                            break;
                        case 3:
                            System.out.println("nhap ma bai hat can thay doi : ");
                            String idSubEdit = scanner.nextLine();
                            Song songUpdate = findSongById(songs, songIndex, idSubEdit);
                            if (songUpdate != null) {
                                songUpdate.inputData(singers, singerIndex);
                                System.out.println("cap nhat thanh cong");
                            } else {
                                System.out.println("k tim thay bai hat co ma id :" + idSubEdit);
                            }
                            break;
                        case 4:
                            //xoa thong tin mon hoc
                            System.out.println("nhap ma bai hat can xoa : ");
                            String idSongDelete = scanner.nextLine();
                            for (int i = 0; i < songIndex; i++) {
                                if (songs[i].getSongId() == idSongDelete) {
                                    for (int j = i; j < songs.length; j++) {
                                        songs[j] = songs[j + 1];
                                    }
                                    songIndex--;
                                }
                            }
                            break;
                        case 5:
                            System.out.println("thoat");
                            break;
                    }
                case 3:
                    System.out.println("""
                            *********************SEARCH-MANAGEMENT************************
                            1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại
                            2.Tìm kiếm ca sĩ theo tên hoặc thể loại 
                            3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần 
                            4.Hiển thị 10 bài hát được đăng mới nhất 
                            5.Thoát
                                                        
                            """);
                    int choisenext= Integer.parseInt(scanner.nextLine());
                    switch (choisenext) {
                        case 1:
                            System.out.print("tim kiem bai hat theo ten ca si or the loai: ");
                            String text1 = scanner.nextLine();
                            check = false;
                            for (int i = 0; i < singerIndex; i++) {
                                if (singers[i].getSingerName().contains(text1) || singers[i].getGenre().contains(text1)) {
                                    System.out.println("bai hat " + (i + 1) + ":");
                                    singers[i].DisplayData();
                                    check = true;
                                }
                            }
                            if (!check) {
                                System.out.println("Khong tim thay bai hat nao voi tu khoa " + "\'" + text1 + "\'");
                            }

                            break;
                        case 2:
                            System.out.print("tim kiem ca si theo ten: ");
                            String text2 = scanner.nextLine();
                            check = false;
                            for (int j = 0; j < singerIndex; j++) {
                                if (songs[j].getSongName().contains(text2)) {
                                    System.out.println("ca si: " + (j + 1) + ":");
                                    songs[j].displayData();
                                    check = true;
                                }
                            }
                            if (!check) {
                                System.out.println("Khong tim thay ca si nao voi tu khoa " + "\'" + text2 + "\'");
                            }

                            break;
                        case 3:
                            Arrays.sort(songs, 0, songIndex, (b1, b2) -> b1.getSongName().compareTo(b2.getSongName()));
                            System.out.println("danh sach bai hat theo thu tu tang len dan la: ");
                            for (int i = 0; i < songIndex; i++) {
                                System.out.println(songs[i].getSongName());
                            }
                            break;
                        case 4:
                            for (int i = songIndex - 1, j = 0; i >= 0 && j < 10; i--, j++) {
                                songs[i].displayData();
                            }
                    }
                            break;
                default:
                    System.out.println("ket thuc.");
            }
        } while (choice != 4);
    }

    // Phương thức tìm kiếm ca sĩ theo id
    private static int findSingerIndexById(Singer[] singers, int singerIndex, int id) {
        for (int i = 0; i < singerIndex; i++) {
            if (singers[i].getSingerId() == id) {
                return i;
            }
        }
        return -1;
    }

    // Phương thức kiểm tra xem một ca sĩ có bài hát không
    private static boolean isSingerHasSong(Song[] songs, int songIndex, int id) {
        for (int i = 0; i < songIndex; i++) {
        }
        return false;
    }

    // Phương thức xóa ca sĩ
    private static void deleteSinger(Singer[] singers, int singerIndex, int index) {
        for (int i = index; i < singerIndex - 1; i++) {
            singers[i] = singers[i + 1];
        }
        singers[singerIndex - 1] = null;
    }


    private static Song findSongById(Song[] songs, int songIndex, String songId) {
        for (int i = 0; i < songIndex; i++) {
            if (songs[i] != null && songs[i].getSongId().equals(songId)) {
                return songs[i];
            }
        }
        return null;//k tim thay
    }

}
