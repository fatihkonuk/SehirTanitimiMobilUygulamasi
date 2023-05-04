package com.fatihkonuk.sehirtanitim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class fk_Repository {
    public ArrayList<fk_Section> sections;
    public ArrayList<fk_SubSection> subSections;
    public ArrayList<fk_Content> contents;

    public fk_Repository() {
        sections = new ArrayList<>(Arrays.asList(
            new fk_Section(1,"Tokat Tarihçesi"),
            new fk_Section(2,"Tokat'ta bulunan tarihi yerler"),
            new fk_Section(3,"Tokat Yöresel Yemekleri"),
            new fk_Section(4,"Tokat Yöresel Tatlıları")
        ));

        subSections = new ArrayList<>(Arrays.asList(
            new fk_SubSection(1,"Tokat Ulu Camii",2),
            new fk_SubSection(2,"Ballıca Mağarası",2),
            new fk_SubSection(3,"Tokat Kalesi",2),
            new fk_SubSection(4,"Mahperi Hatun Kervansarayı",2),
            new fk_SubSection(5,"Hıdırlık Köprüsü",2),
            new fk_SubSection(6,"Tokat Kebabı",3),
            new fk_SubSection(7,"Yaprak Sarma",3),
            new fk_SubSection(8,"Katmer",3),
            new fk_SubSection(9,"Turhal Yoğurtmacı",3),
            new fk_SubSection(10,"Zile Pekmezi",4),
            new fk_SubSection(11,"Şeker Sucuğu",4),
            new fk_SubSection(12,"Zambak Reçeli",4)
        ));

        contents = new ArrayList<>(Arrays.asList(
            new fk_Content(
                0,
                "Tokat Şehri",
                "Tokat; Yeşilırmak havzasının bereketli toprakları üzerinde kurulmuş olmasının verdiği avantajla 6000 yıllık tarihi boyunca önemli bir ticaret ve kültür merkezi olmuş, 14 Devleti ve birçok Beyliği içerisinde barındırmış, önemli bir Anadolu şehridir.\n" +
                        "\n" +
                        "Hatti, Hitit, Frig, Roma, Bizans, Danişmendli, İlhanlı, Selçuklu ve Osmanlı Dönemine kadar gelişen süreç içerisinde tarihin her dönemine ait eserleri Tokat'ın her bölgesinde bulabilmek mümkündür. Bu yönüyle Tokat bir açık hava müzesi konumundadır.\n" +
                        "\n" +
                        "Erbaa ilçesinde antik Horoztepe yerleşimi, Hitit yerleşim yeri, Zile'de Maşathöyük Ören Yeri, Sulusaray'da; Roma-Bizans Dönemlerinin izlerini taşıyan Sebastapolis, Merkez ilçede, tarihi Komana şehri, yine Roma Döneminde yol güvenliği için kurulmuş olan Tokat Kalesi, aynı zamanda Danişmend Devletine başkentlik yapmış olan Niksar'da bulunan tarihi kale, Malazgirt sonrası yapılan en eski Türk Camisi Garipler Camii, Yağıbasan Medresesi, Gökmedrese, Yeşilırmak-Hıdırlık Köprüsü, 9 adet zaviye, Osmanlı Dönemine ait Alipaşa Camii ve Hamamı, Voyvoda Han ( Taşhan), Deveciler Hanı, Arastalı Bedesten, 18. yüzyıla ait bütün Anadolu'nun en görkemli tavan göbeğine sahip Latifoğlu Konağı Müze Evi ve Anadolu'nun en güzel ahşap Mevlevihanesi, en güzel Saat Kulesi; Bey Sokağı, Bey Hamam Sokağı, Halit Sokağı ve Sulusokak'ta bulunan sivil mimarlık örneği yapılarla; Türklerin Anadolu'ya gelişlerinden itibaren 900 yılda mimarlık adına ortaya koydukları önemli eserlerin kesintisiz olarak görülebileceği tek şehirdir.",
                R.drawable.tokat,
                0
            ),
            new fk_Content(
                1,
                "Tokat Ulu Camii",
                "İlk olarak Danişmendliler Dönemi'nde XIII. yüzyılda yapılmış, 1679 yılında Avcı Mehmed zamanında tamamen yenilenmiştir. Dikdörtgen planlı olarak inşa edilmiştir.\n\nDoğu ve batı yönünde iki adet son cemaat yeri bulunmaktadır. Bu özelliği ile Anadolu’da tektir. \n\nHer iki tarafta da devşirme sütun ve sütun başlıkları kullanılmıştır. Güneydoğu köşesindeki taşa oyulmuş, kuş evi Anadolu’da nadir olarak görülür. \n\nCaminin harimi ahşap tavan ile örtülmüştür. Tavana kırmızı ve yeşil renklerin hakim olduğu fonlar arasında yalancı kündekari tekniğiyle yapılmış kare tavan göbeğinin üzeri altın yaldız ve kalem işi bitkisel bezemelerle süslenmiştir. Ahşap tavanı taşıyan ayak ve kemerlerin üzeri dönemin süsleme özelliklerine uygun olarak Rumi motifli kalem işleriyle süslenmiştir.",
                R.drawable.m_ulucamii,
                1
            ),
            new fk_Content(
                2,
                "Ballıca Mağarası",
                "Ballıca Mağarası, Tokat'ın 26 km. güney batısında yer alan Pazar ilçesinin Ballıca Köyü'nde, deniz seviyesine göre 1.085 m. rakımda yer alıyor. \n\nPazar ilçesinden Ballıca Mağarası'na ulaşan 8 km'lik yol, Kral Yolu'na bağlanan Selçuklu Dönemi'ne ait bir köprünün yanından geçiyor. \n\nYapımı 1238 yılına tarihlenen ve 2006 yılında restorasyon çalışmalarına başlanan Mahperi Sultan Kervansarayı da Mağara yolu üzerinde yer alıyor.\n\n1987 yılında başlayan araştırma ve haritalandırma çalışmalarını 1995 yılında yapılan yürüme yolları ve ışıklandırma çalışmaları izlemiştir. \n\nBallıca Mağarası, kristalleşmiş kireçtaşlarından meydana gelmiştir ve ziyarete açılan bölümlerinde 8 salon gezilebilir. Ortalama sıcaklığı 18 C ve ortalama nem oranı % 54 olan mağaranın bol oksijenli havası nefes almayı kolaylaştırmaktadır.",
                R.drawable.m_ballicamagrasi,
                2
            ),
            new fk_Content(
                3,
                "Tokat Kalesi",
                "M.Ö 30- M.S 395 Roma döneminde yol güvenliği için kurulmuş olan Kale, yaklaşık 500 yıl Bizans egemenliğinde kalmıştır. İlk defa 1074 yılında Danişmend Melik Ahmet Gazi tarafından fethedilen Kale kısa aralıklarla el değiştirmiş olup sırasıyla Danişmentli, Selçuklu, İlhanlı, Eratna, Kadı Burhanettin ve Osmanlı Devleti’nin egemenliğine geçmiştir. Dik ve sarp kayalar üzerine kurulu Kale, doğal bir hisar durumundadır. Osmanlı Devleti zamanında “Çardak–ı Bedevi“ denilen zindanı başta Bizans İmparatoru A. Diogenis olmak üzere birçok ünlünün tutsak yeri olmuştur.\n" +
                        "\n" +
                        "Korku filmlerinin efsanevi kahramanı diğer adıyla Kazıklı Voyvoda! Osmanlılara yenik düşen Eflak (Romanya) krallığı prensi olan III. Vlad, yani Drakula zamanında kardeşi  ile birlikte önce Kütahya Eğrigöz Kalesi’nde, daha sonra Tokat Kalesi’nde gözetim altında tutulduktan sonra da Edirne’ye şehzade Mehmet’in (Fatih Sultan Mehmet) yanına gönderilmiş, belli bir süre eğitim alması sağlanmıştır.\n" +
                        "\n" +
                        "Kale’nin güney batısında çok eski çağlardan kalma bir Kaya Mezarı oyulmuştur. Mezarın ağzında bir kolon ve biri büyük iki hücre bulunmaktadır. Ayrıca 362 basamaklı bir merdiven ile Kale’nin dibine inilebilmektedir. Günümüzde bu merdiven yolunun büyük bir kısmı açılmış durumdadır.",
                R.drawable.m_tokatkalesi,
                3
            ),
            new fk_Content(
                4,
                "Mahperi Hatun Kervansarayı",
                "Mahperi Hatun Kervansarayı, Tokat-Pazar yolunun 29'uncu kilometresinde Pazar İlçesi'ne yaklaşık 1 kilometre mesafede, yolun güneydoğusundaki kuzeybatıya meyilli bir araziye inşa edilmiştir. Avlu ve kapalı kısım portallerindeki dörder satırlık sülüs hatlı kitabelerine göre, 1238 yılında Alaeddin Keykubâd’ın zevcesi ve II.Gıyaseddin Keyhüsrev’in validesi Mahperi Hatun tarafından yaptırılmıştır.\n\nKervansaray yazlık ve kışlık olmak üzere iki bölümden oluşuyor. Yazlık kısım avlu etrafında çevrili revak ve arkasındaki bölümler, kışlık kısım ise payelerle bölünmüş dışarıya tamamen kapalı şekilde tasarlanmış.\n\nBu kervansaray karma tip denilen hem açık hem de kapalı kervansaraylar grubuna giriyor. Kervansarayın taçkapısında, kapalı bölümün taçkapısında ve çeşme alınlığında üç adet kitabesi mevcut.\n" +
                        "\n" +
                        "Kesme taştan dikdörtgen olarak yapılan kervansaray, adeta tarihe meydan okuyan gösterişli giriş kapısı dikdörtgen şekilde olmakla birlikte sivri kemerli bir niş içerisinde bulunuyor.Aynı zamanda yapım kitabesinin de üzerinde bulunduğu giriş kapısı iki renkli taştan oluşturulmuş.\n" +
                        "\n" +
                        "Üst kısmı yıkılan kervansarayın yan duvarları ve görkemli kapısı zamana karşı direnip bu yoldan geçip giden onca yolcuya halen selam duruyor. Amasya-Tokat yolunun 90’ıncı kilometresinde yer alan bu tarihi yapı geçip gidenlere karşı durup dinlenmek isteyenlere kapılarını açık tutuyor.",
                R.drawable.m_mahperihatun,
                4
            ),
            new fk_Content(
                5,
                "Hıdırlık Köprüsü",
                "Yeşilırmak Köprüsü olarak da bilinen Hıdırlık Köprüsü Yeşilırmak üzerine inşa edilmiştir. Selçuklu döneminde 1250 yılında Hamid bin Ebul Kasım Bin Ali el Tusi tarafından yapmıştır. 151 metre uzunluğuna sahip olan köprü 5 kemerli ve yedi metre genişliğine sahiptir. Günümüzde Trafiğe kapalı bir şekilde yaya olarak kullanılmaktadır. \n\nTokat ilimizde Selçuklu dönemine ait 4 adet köprü vardır. Lakin Hıdırlık Köprüsü diğer köprülerden faklıdır. Onu farklı yapan özelliği Selçuklu sülüs denilen yazı tipiyle yazılmış 4 satırlık kitabe yer almasıdır. Bu görkemli köprünün yapılmasının bir hikayesi de mevcut.\n" +
                        "\n" +
                        "Selçuklu Sultanı 2.Gıyaseddin Keyhüsrev’in üç oğlunu barıştırmak için yaptırmış. Söylenenlere göre İzzeddin, Rukneddin ve Alaaddin üç yıl boyunca birbirlerine küslermiş. Ve üç yıl boyunca kendi aralarında çatışma söz konusuymuş. 2.Gıyaseddin Keyhüsrev üç oğlunu bir araya getirmek ve aralarındaki küslüğe son vermeleri için köprüyü yaptırıyor ve bu sayede aralarındaki küslük son buluyor. Hatta köprünün üzerindeki kitabe de üç kardeşin isimleri de yazılmaktadır. Tarihin pek çok izlerini taşıyan Hıdırlık Köprüsü Hem kitabeleri hem de hikayesi ile oldukça ilgi çekmektedir.",
                R.drawable.m_hidirlikkoprusu,
                5
            ),
            new fk_Content(
                6,
                "Tokat Kebabı",
                "Tokat yöresinde yapılan “Tokat Kebabı”, adını yıllardır Tokat ilinde kendine has üretim yöntemiyle yapılmasından dolayı almaktadır. Tokat ve çevresinde ticari bir ürün haline gelmeden önce bağ evlerinde özel günlerde yapılan Tokat Kebabı, malzemelerini oluşturan gıda ürünlerinin kendine has üretim yöntemine göre bir araya getirilip, şekillendirilmesi ve kendine özgü Tokat Kebabı ocağında pişirilmesiyle elde edilen kebap olarak tanımlanabilir.",
                R.drawable.y_tokatkebabi,
                6
            ),
            new fk_Content(
                7,
                "Yaprak Sarma",
                "Geleneksel Türk mutfağının temellerinden biri olan sarma, etrafı yapraklarla veya yapraklı sebzelerle sıkıca çevrili bir dolgudan oluşur. Bu yemeğin çok sayıda çeşidi vardır, ancak karışım tipik olarak kıyma, pirinç veya bulgur, çeşitli otlar, baharatlar, kırmızı biber, öğütülmüş sumak veya domates sosu gibi malzemeleri birleştirirken, sargı genellikle asma, lahana yaprakları veya pazı gibi çeşitli yapraklı sebzelerdir.",
                R.drawable.y_yapraksarmasi,
                7
            ),
            new fk_Content(
                8,
                "Katmer",
                "Tokat mutfağının en klasik ve sevilen tariflerinden biri Tokat yağlaması. Hamur işi lezzetlerinden olan tuzlu katmer tarifine de pek benziyor. Mantığı açılan bezelerin tereyağıyla buluşup katlanması, ardından tekrar açılıp pişirilmesi mantığına dayanıyor. Bu sayede tel tel olan nefis bir hamur işine dönüşüyor. Tokat'ın bu nefis ve meşhur lezzetini mutlaka deneyin.",
                R.drawable.y_katmer,
                8
            ),
            new fk_Content(
                9,
                "Turhal Yoğurtmacı",
                "Turhal yöresinde yapılan “Yoğurtmaç”, adını yoğurma ve katlama kelimesinden almaktadır. Turhal ve çevresinde ticari bir ürün haline gelmeden önce bayramlarda ve özel günlerde misafirlere ikram etmek için yapılan yoğurtmaç; hamur ve iç malzemenin kendine has üretim yöntemine göre bir araya getirilip şekillendirilmesi ve taş tabanlı fırınlarda pişirilmesiyle elde edilen yöreye özgü bir ürün olup; haşhaşlı, cevizli veya sade olarak üretilmektedir. ",
                R.drawable.y_yogurtmac,
                9
            ),
            new fk_Content(
                10,
                "Zile Pekmezi",
                "Zile Pekmezi adını Tokat ilinin Zile ilçesinden alır. Beyaz renkte olan Zile Pekmezi Tokat’ın Zile ilçesinin narince üzümlerinin yumurta akı ile karıştırılarak bir takım işlemlerden geçilmesiyle elde edilen pekmez çeşididir. Ülkemizde uzun yıllardır tüketildiği gibi Avrupa’da da sıklıkla tercih edilen bir pekmez türüdür.\n" +
                        "\n" +
                        "Besin değeri olarak oldukça besleyici olan meşhur Zile Pekmezi baldan daha zengin içeriğe sahiptir. Ayrıca anne sütünü artırma ve kansızlık giderme gibi önemli bir çok faydası vardır.",
                R.drawable.t_zilepekmezi,
                10
            ),
            new fk_Content(
                11,
                "Şeker Sucuğu",
                "Anadolu mutfağında önemli bir yere sahip olan mum şekilli tatlıdır. Orcik, köme, şekerli sucuk veya pekmezli sucuk isimleriyle de bilinir. Cevizli sucuğun yapımını, ipe dizilmiş cevizin kaynatılmış şıraya batırıldıktan sonra asılarak kurutulması olarak özetleyebiliriz.",
                R.drawable.t_cevizlisekersucugu,
                11
            ),
            new fk_Content(
                12,
                "Zambak Reçeli",
                "Zambağın ortasındaki yeşil kök kısımları çıkarılarak yapraklar birkaç parçaya bölünür. Üzerine bir çay bardağı toz şeker ekilerek ağzı kapatılır. 1 gün buzdolabında bekletilir. Kalan şeker ve su kıvamlanana kadar kaynatılır. Şekerde bekletilen zambak ve limon suyu ilave edilerek reçel kıvamına gelene kadar kaynatılır. Soğutulduktan sonra kavanozlanarak saklanır.",
                R.drawable.t_zambakreceli,
                12
            )
        ));
    }

    public ArrayList<fk_Section> getAllSections() {
        return sections;
    }

    public ArrayList<fk_SubSection> getSubSectionsByParentId(int id) {
        return (ArrayList<fk_SubSection>)
            subSections.stream().filter(x->x.parentId == id).collect(Collectors.toList());
    }

    public fk_Content getContentByParentId(int id) {
        return contents.stream().filter(c -> c.parentId == id).findFirst().orElse(null);
    }
}
