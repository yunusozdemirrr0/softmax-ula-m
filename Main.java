public class Main {

    static class Agirliklar {
        static double nufus_yogunlugu = 0.25;
        static double mevcut_ulasim_altyapisi = 0.20;
        static double maliyet_analizi = 0.25;
        static double cevresel_etki = 0.15;
        static double sosyal_fayda = 0.15;
    }

    static class CumhuriyetMahallesi {
        static int nufus_yogunlugu = 9;
        static int mevcut_ulasim_altyapisi = 3;
        static int maliyet_analizi = 4;
        static int cevresel_etki = 5;
        static int sosyal_fayda = 8;
    }

    static class KarakasMahallesi {
        static int nufus_yogunlugu = 6;
        static int mevcut_ulasim_altyapisi = 8;
        static int maliyet_analizi = 7;
        static int cevresel_etki = 8;
        static int sosyal_fayda = 6;
    }

    static class AtaturkMahallesi {
        static int nufus_yogunlugu = 3;
        static int mevcut_ulasim_altyapisi = 4;
        static int maliyet_analizi = 6;
        static int cevresel_etki = 3;
        static int sosyal_fayda = 4;
    }

    static class AgirlikliSkorHesaplama {

        static double skor_c1 = Agirliklar.nufus_yogunlugu * CumhuriyetMahallesi.nufus_yogunlugu;
        static double skor_c2 = Agirliklar.mevcut_ulasim_altyapisi * CumhuriyetMahallesi.mevcut_ulasim_altyapisi;
        static double skor_c3 = Agirliklar.maliyet_analizi * CumhuriyetMahallesi.maliyet_analizi;
        static double skor_c4 = Agirliklar.cevresel_etki * CumhuriyetMahallesi.cevresel_etki;
        static double skor_c5 = Agirliklar.sosyal_fayda * CumhuriyetMahallesi.sosyal_fayda;

        static double skor_k1 = Agirliklar.nufus_yogunlugu * KarakasMahallesi.nufus_yogunlugu;
        static double skor_k2 = Agirliklar.mevcut_ulasim_altyapisi * KarakasMahallesi.mevcut_ulasim_altyapisi;
        static double skor_k3 = Agirliklar.maliyet_analizi * KarakasMahallesi.maliyet_analizi;
        static double skor_k4 = Agirliklar.cevresel_etki * KarakasMahallesi.cevresel_etki;
        static double skor_k5 = Agirliklar.sosyal_fayda * KarakasMahallesi.sosyal_fayda;

        static double skor_a1 = Agirliklar.nufus_yogunlugu * AtaturkMahallesi.nufus_yogunlugu;
        static double skor_a2 = Agirliklar.mevcut_ulasim_altyapisi * AtaturkMahallesi.mevcut_ulasim_altyapisi;
        static double skor_a3 = Agirliklar.maliyet_analizi * AtaturkMahallesi.maliyet_analizi;
        static double skor_a4 = Agirliklar.cevresel_etki * AtaturkMahallesi.cevresel_etki;
        static double skor_a5 = Agirliklar.sosyal_fayda * AtaturkMahallesi.sosyal_fayda;

        public static double toplamSkorCumhuriyet() {
            return skor_c1 + skor_c2 + skor_c3 + skor_c4 + skor_c5;
        }

        public static double toplamSkorKarakas() {
            return skor_k1 + skor_k2 + skor_k3 + skor_k4 + skor_k5;
        }

        public static double toplamSkorAtaturk() {
            return skor_a1 + skor_a2 + skor_a3 + skor_a4 + skor_a5;
        }
    }

    public static double[] softmax(double[] degerler) {
        double max = degerler[0];
        for (double deger : degerler) {
            if (deger > max) {
                max = deger;
            }
        }
        double toplam = 0.0;
        double[] expDegerler = new double[degerler.length];
        for (int i = 0; i < degerler.length; i++) {
            expDegerler[i] = Math.exp(degerler[i] - max);
            toplam += expDegerler[i];
        }
        double[] olasiliklar = new double[degerler.length];
        for (int i = 0; i < degerler.length; i++) {
            olasiliklar[i] = expDegerler[i] / toplam;
        }
        return olasiliklar;
    }

    public static void main(String args[]) {
        double toplamCumhuriyet = AgirlikliSkorHesaplama.toplamSkorCumhuriyet();
        double toplamKarakas = AgirlikliSkorHesaplama.toplamSkorKarakas();
        double toplamAtaturk = AgirlikliSkorHesaplama.toplamSkorAtaturk();

        System.out.println("Cumhuriyet Mahallesi Toplam Skoru: " + toplamCumhuriyet);
        System.out.println("Karakas Mahallesi Toplam Skoru: " + toplamKarakas);
        System.out.println("Ataturk Mahallesi Toplam Skoru: " + toplamAtaturk);

        double[] skorlar = {toplamCumhuriyet, toplamKarakas, toplamAtaturk};
        double[] olasiliklar = softmax(skorlar);

        System.out.println("\nMahallelerin Seçilme Olasılıkları:");
        System.out.println("Cumhuriyet Mahallesi: " + olasiliklar[0]);
        System.out.println("Karakas Mahallesi: " + olasiliklar[1]);
        System.out.println("Ataturk Mahallesi: " + olasiliklar[2]);

        double maxOlasiklik = olasiliklar[0];
        int enUygunIndex = 0;
        for (int i = 1; i < olasiliklar.length; i++) {
            if (olasiliklar[i] > maxOlasiklik) {
                maxOlasiklik = olasiliklar[i];
                enUygunIndex = i;
            }
        }

        String enUygunMahalle = "";
        switch (enUygunIndex) {
            case 0:
                enUygunMahalle = "Cumhuriyet Mahallesi";
                break;
            case 1:
                enUygunMahalle = "Karakas Mahallesi";
                break;
            case 2:
                enUygunMahalle = "Ataturk Mahallesi";
                break;
        }

        System.out.println("\nEn Uygun Güzergah: " + enUygunMahalle);
        System.out.println("Maliyet-Fayda Analizi Gerçekleştirildi.");
    }
}
