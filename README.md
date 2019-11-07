# fuzzy-logic
Using fuzzy logic, making predictions over a dataset


## Veri seti: https://archive.ics.uci.edu/ml/datasets/Occupancy+Detection+ 
Veri setinde; Temperature (Sıcaklık), Humidity (Nem), Light (Işık), Karbondioksit (CO2), Nem Oranı (Humidity Ratio) ve Occupancy (Dolu mu Boş mu) durumu yazıyor. Burada Temperature, Humidity, Light, CO2, Humidity Ratio girdiler. Occupancy çıktı olacak. 

## Üyelik Fonksiyonlarının ve Sınır Değerlerinin Belirlenmesi
### Temperature (Sıcaklık):
Sıcaklık cinsi Celcius olarak verilmiş. Verilen değerlerden sınır değerlerini belirleyebilmek için öncelikle veri setinde ki en düşük, 
ortalama ve en yüksek sıcaklığı buldum.

En Düşük Sıcaklık: 19.0 ℃ 

Ortalama Sıcaklık: 20.61 ℃ 

En Yüksek Sıcaklık: 23.18 ℃ 

Bu bilgiler çerçevesinde arada çok az fark olduğu için ve bu aralıkta değerler için soğuk denilemeyeceği için 2 dilsel değişken belirledim.  Ilık ve sıcak;
19 ile 21 derece arasına ılık deyip üçgen üyelik fonksiyonu kullandım.
20 ile 25 arasında sıcak ve yamuk üyelik fonksiyonu tanımladım.

Humidity (Nem): Nem içinde aynı şekilde sınır değerleri belirleyebilmek için en düşük, ortalama ve en yüksek değerleri inceledim. 
En Düşük Nem: 16.745
Ortalama Nem: 25.731
En Yüksek Nem: 39.115
3 dilsel değişken tanımladım (az, orta, çok), az için yamuk üyelik fonksiyonu, orta için üçgen üyelik fonksiyonu ve çok için yamuk üyelik fonksiyonu tanımladım.
