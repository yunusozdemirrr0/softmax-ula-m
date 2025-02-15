# softmax-ulasim
Mahalle Seçim Uygulaması
Bu proje, belirli kriterlere göre (nüfus yoğunluğu, ulaşım altyapısı, maliyet analizi, çevresel etki ve sosyal fayda) mahalleleri değerlendirip en uygun güzergahı belirlemeyi amaçlar.

Özellikler
Kriter Ağırlıkları: Her kriterin önemini belirlemek için tanımlı ağırlıklar kullanılır.
Mahalle Puanları: Her mahalle için belirlenen kriterlere göre puanlar verilir.
Ağırlıklı Skor Hesaplaması: Her mahallenin puanları, ilgili kriter ağırlıkları ile çarpılarak toplam skor hesaplanır.
Softmax Normalizasyonu: Hesaplanan skorlar softmax fonksiyonu ile normalize edilip, her mahalle için seçilme olasılıkları oluşturulur.
En Uygun Seçim: En yüksek olasılığa sahip mahalle, en uygun güzergah olarak seçilir.
Dosya Açıklaması
Main.java:
Agirliklar: Kriter ağırlıklarını tanımlar.
CumhuriyetMahallesi, KarakasMahallesi, AtaturkMahallesi: Her mahalle için kriter puanlarını içerir.
AgirlikliSkorHesaplama: Her mahalle için ağırlıklı skorları hesaplar.
softmax: Hesaplanan skorları 0-1 arası normalize eder.
main: Programın çalıştığı ve sonuçların ekrana yazdırıldığı kısımdır.
