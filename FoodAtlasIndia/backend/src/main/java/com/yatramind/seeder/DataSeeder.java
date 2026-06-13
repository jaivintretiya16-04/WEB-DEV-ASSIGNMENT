package com.yatramind.seeder;

import com.yatramind.entity.*;
import com.yatramind.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final CityRepository cityRepository;
    private final PlaceRepository placeRepository;
    private final HotelRepository hotelRepository;
    private final FoodRepository foodRepository;
    private final TransportRepository transportRepository;

    @Override
    public void run(String... args) {
        if (cityRepository.count() > 0) {
            log.info("Data already seeded. Skipping.");
            return;
        }
        log.info("Seeding YatraMind database...");
        seedCities();
        seedTransport();
        log.info("Seeding complete!");
    }

    private void seedCities() {
        // --- Jaipur ---
        City jaipur = cityRepository.save(City.builder().name("Jaipur").state("Rajasthan").tagline("The Pink City").description("Royal heritage and vibrant culture").category("Heritage").rating(4.7).bestTime("Oct-Mar").language("Hindi, Rajasthani").imageUrl("https://images.unsplash.com/photo-1599661046289-e31897846e41?w=800").build());
        placeRepository.saveAll(List.of(
            Place.builder().name("Amber Fort").description("Majestic hilltop fort with stunning architecture").category("Fort").rating(4.8).timings("8AM-5:30PM").entryFee("₹200").imageUrl("https://plus.unsplash.com/premium_photo-1661963054563-ce928e477ff3?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8YW1iZXIlMjBmb3J0fGVufDB8fDB8fHww").city(jaipur).build(),
            Place.builder().name("Hawa Mahal").description("Iconic Palace of Winds with 953 windows").category("Monument").rating(4.6).timings("9AM-5PM").entryFee("₹50").imageUrl("https://images.unsplash.com/photo-1602643163983-ed0babc39797?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8aGF3YSUyMG1haGFsfGVufDB8fDB8fHww").city(jaipur).build(),
            Place.builder().name("City Palace").description("Blend of Rajasthani and Mughal architecture").category("Monument").rating(4.5).timings("9:30AM-5PM").entryFee("₹300").imageUrl("https://images.unsplash.com/photo-1589901164570-f9de6556e1c1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8Y2l0eSUyMHBhbGFjZXxlbnwwfHwwfHx8MA%3D%3D").city(jaipur).build()
        ));
        hotelRepository.saveAll(List.of(
            Hotel.builder().name("Rambagh Palace").type("5 Star").nearPlace("City Palace").rating(4.9).pricePerNight(25000).amenities("WiFi,Pool,Spa,Restaurant,Heritage").imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(jaipur).build(),
            Hotel.builder().name("ITC Rajputana").type("5 Star").nearPlace("Hawa Mahal").rating(4.7).pricePerNight(8500).amenities("WiFi,Pool,Restaurant,Gym").imageUrl("https://images.unsplash.com/photo-1564501049412-61c2a3083791?w=400").city(jaipur).build(),
            Hotel.builder().name("Hotel Pearl Palace").type("Budget").nearPlace("Hawa Mahal").rating(4.4).pricePerNight(1500).amenities("WiFi,Restaurant,AC").imageUrl("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?w=400").city(jaipur).build()
        ));
        foodRepository.saveAll(List.of(
            Food.builder().name("Dal Baati Churma").price(350).isVeg(true).rating(4.6).description("Traditional Rajasthani baked wheat balls with lentils").category("Main Course").restaurant("Chokhi Dhani").priceRange("₹300-500").mustTry(true).imageUrl("https://media.istockphoto.com/id/1458973879/photo/rajasthani-traditional-cuisine-dal-baati.jpg?s=1024x1024&w=is&k=20&c=Et1no8evm3pU9qnZRFQQoC9gBox0oD5DFLSiqcKzC6g=").city(jaipur).build(),
            Food.builder().name("Pyaaz Kachori").price(45).isVeg(true).rating(4.7).description("Crispy deep-fried pastry with spiced onion filling").category("Street Food").restaurant("Rawat Mishthan Bhandar").priceRange("₹30-60").mustTry(true).imageUrl("https://media.istockphoto.com/id/1080619592/photo/shegaon-or-rajasthani-kachori-served-with-green-chutney-and-tomato-ketchup.webp?a=1&b=1&s=612x612&w=0&k=20&c=KCUPwLhwq7dP4NF9LHSgVzAIPnnNIannj370-7r-qH8=").city(jaipur).build(),
            Food.builder().name("Ghewar").price(180).isVeg(true).rating(4.3).description("Traditional Rajasthani disc-shaped sweet cake").category("Sweet").restaurant("LMB").priceRange("₹100-300").mustTry(false).imageUrl("https://media.istockphoto.com/id/845078294/photo/rajasthani-ghevar-or-ghewar-indian-sweets.jpg?s=1024x1024&w=is&k=20&c=VdhwrcJTByZMi0X_RTHtlm_2D3brc7U92rFIEbRYbAM=").city(jaipur).build()
        ));

        // --- Goa ---
        City goa = cityRepository.save(City.builder().name("Goa").state("Goa").tagline("Sun, Sand & Serenity").description("India's beach paradise with Portuguese charm").category("Beach").rating(4.6).bestTime("Nov-Feb").language("Konkani, English").imageUrl("https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=800").build());
        placeRepository.saveAll(List.of(
            Place.builder().name("Baga Beach").description("Popular beach with water sports and nightlife").category("Beach").rating(4.5).timings("24 Hours").entryFee("Free").imageUrl("https://images.unsplash.com/photo-1512343879784-a960bf40e7f2?w=400").city(goa).build(),
            Place.builder().name("Basilica of Bom Jesus").description("UNESCO World Heritage Site, Portuguese architecture").category("Monument").rating(4.7).timings("9AM-6:30PM").entryFee("Free").imageUrl("https://images.unsplash.com/photo-1768728678060-598c3b983b3f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8Y2l0eSUyMHBhbGFjZXxlbnwwfHwwfHx8MA%3D%3D").city(goa).build()
        ));
        hotelRepository.saveAll(List.of(
            Hotel.builder().name("Taj Exotica").type("5 Star").nearPlace("Baga Beach").rating(4.8).pricePerNight(15000).amenities("WiFi,Pool,Spa,Beach Access,Restaurant").imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(goa).build(),
            Hotel.builder().name("OYO Beach Stay").type("Budget").nearPlace("Baga Beach").rating(3.9).pricePerNight(1200).amenities("WiFi,AC").imageUrl("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?w=400").city(goa).build()
        ));
        foodRepository.saveAll(List.of(
            Food.builder().name("Goan Fish Curry").price(450).isVeg(false).rating(4.5).description("Tangy coconut-based fish curry").category("Main Course").restaurant("Fisherman's Wharf").priceRange("₹400-600").mustTry(true).imageUrl("https://images.unsplash.com/photo-1654863404432-cac67587e25d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Z29hbiUyMGZpc2glMjBjdXJyeXxlbnwwfHwwfHx8MA%3D%3D").city(goa).build(),
            Food.builder().name("Bebinca").price(200).isVeg(true).rating(4.4).description("Traditional Goan layered pudding dessert").category("Sweet").restaurant("Cafe Bodega").priceRange("₹150-250").mustTry(true).imageUrl("https://media.istockphoto.com/id/1352250764/photo/bebinka-on-platter-close-up-bibik-a-national-dessert-in-goa-india-multi-layer-sweet-pudding.jpg?s=1024x1024&w=is&k=20&c=NMaZOBuq0y9E56TdxFVLoavdvyzJE2LYllAzSxCBxbs=").city(goa).build()
        ));

        // --- Varanasi ---
        City varanasi = cityRepository.save(City.builder().name("Varanasi").state("Uttar Pradesh").tagline("City of Light").description("India's spiritual capital on the Ganges").category("Heritage").rating(4.5).bestTime("Oct-Mar").language("Hindi").imageUrl("https://media.istockphoto.com/id/827065008/photo/holy-town-varanasi-and-the-river-ganges.webp?a=1&b=1&s=612x612&w=0&k=20&c=QtEgeqRAUw0e45r54qW9I79H0hxqk0_3klw_B3xD_rY=").build());
        placeRepository.saveAll(List.of(
            Place.builder().name("Dashashwamedh Ghat").description("Main ghat famous for Ganga Aarti ceremony").category("Temple").rating(4.8).timings("24 Hours").entryFee("Free").imageUrl("https://images.unsplash.com/photo-1772947314926-a3bcffd09b1b?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fERhc2hhc2h3YW1lZGglMjBHaGF0fGVufDB8fDB8fHww").city(varanasi).build(),
            Place.builder().name("Kashi Vishwanath Temple").description("One of the 12 Jyotirlingas, sacred Shiva temple").category("Temple").rating(4.9).timings("3AM-11PM").entryFee("Free").imageUrl("https://images.pexels.com/photos/37349120/pexels-photo-37349120.jpeg?_gl=1*pkll2*_ga*MTM2MjUyNzE5MS4xNzY3NzM0ODg2*_ga_8JE65Q40S6*czE3ODExODcwMDMkbzIkZzEkdDE3ODExODcwMTgkajQ1JGwwJGgw").city(varanasi).build()
        ));
        hotelRepository.saveAll(List.of(
            Hotel.builder().name("Taj Ganges").type("5 Star").nearPlace("Dashashwamedh Ghat").rating(4.6).pricePerNight(7500).amenities("WiFi,Pool,Restaurant,Spa").imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(varanasi).build()
        ));
        foodRepository.saveAll(List.of(
            Food.builder().name("Banarasi Paan").price(50).isVeg(true).rating(4.8).description("Iconic betel leaf preparation with sweet fillings").category("Street Food").restaurant("Keshav Paan Bhandar").priceRange("₹20-100").mustTry(true).imageUrl("https://media.istockphoto.com/id/2050809955/photo/sweet-paan-meetha-pan-betel-leaves-mouth-freshener-traditional-indian-dessert-paan-made-with.webp?a=1&b=1&s=612x612&w=0&k=20&c=CV-T3SC6GSgUvYRuSkzlFuZbS2VVT-qcquK2HI6P26E=").city(varanasi).build(),
            Food.builder().name("Tamatar Chaat").price(40).isVeg(true).rating(4.5).description("Unique tomato-based chaat found only in Varanasi").category("Street Food").restaurant("Deena Chaat").priceRange("₹30-50").mustTry(true).imageUrl("https://images.unsplash.com/photo-1591031107640-45556bbac5f1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8dGFtYXRhciUyMGNoYXR8ZW58MHx8MHx8fDA%3D").city(varanasi).build()
        ));

        // --- Manali ---
        City manali = cityRepository.save(City.builder().name("Manali").state("Himachal Pradesh")
                .tagline("Valley of Gods").description("Snow-capped mountains and adventure sports")
                .category("Mountain").rating(4.7).bestTime("Oct-Jun").language("Hindi, Pahari")
                .imageUrl("https://images.unsplash.com/photo-1593181629936-11c609b8db9b?w=800").build());
        placeRepository.saveAll(List.of(
                Place.builder().name("Rohtang Pass").description("High mountain pass with stunning snow views")
                        .category("Nature").rating(4.7).timings("6AM-4PM").entryFee("₹550")
                        .imageUrl("https://images.unsplash.com/photo-1593181629936-11c609b8db9b?w=400").city(manali)
                        .build(),
                Place.builder().name("Solang Valley").description("Adventure sports hub — paragliding, skiing")
                        .category("Nature").rating(4.6).timings("9AM-5PM").entryFee("₹300")
                        .imageUrl("https://images.unsplash.com/photo-1626621341517-bbf3d9990a23?w=400").city(manali)
                        .build()));
        hotelRepository.saveAll(List.of(
                Hotel.builder().name("The Himalayan").type("4 Star").nearPlace("Solang Valley").rating(4.5)
                        .pricePerNight(6000).amenities("WiFi,Restaurant,Mountain View,Fireplace")
                        .imageUrl("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?w=400").city(manali)
                        .build()));
        foodRepository.saveAll(List.of(
                Food.builder().name("Siddu").price(150).isVeg(true).rating(4.3)
                        .description("Steamed wheat bread stuffed with poppy seeds").category("Main Course")
                        .restaurant("Chopsticks").priceRange("₹100-200").mustTry(true)
                        .imageUrl("https://images.herzindagi.info/image/2023/Aug/how-to-make-siddhu-at-home.jpg").city(manali)
                        .build()));

        // --- Udaipur ---
        City udaipur = cityRepository.save(City.builder().name("Udaipur").state("Rajasthan").tagline("City of Lakes")
                .description("Romantic lakeside city with palatial heritage").category("Heritage").rating(4.8)
                .bestTime("Sep-Mar").language("Hindi, Mewari")
                .imageUrl(
                        "https://plus.unsplash.com/premium_photo-1697729844084-c03db2377161?q=80&w=869&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .build());
        placeRepository.saveAll(List.of(
                Place.builder().name("Lake Pichola").description("Beautiful artificial lake surrounded by palaces")
                        .category("Nature").rating(4.8).timings("9AM-6PM").entryFee("₹400 (boat)")
                        .imageUrl(
                                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0c/77/15/9a/photo0jpg.jpg?w=900&h=500&s=1")
                        .city(udaipur).build(),
                Place.builder().name("City Palace Udaipur").description("Largest palace complex in Rajasthan")
                        .category("Monument").rating(4.7).timings("9:30AM-5:30PM").entryFee("₹300")
                        .imageUrl(
                                "https://res.cloudinary.com/kmadmin/image/upload/v1722936925/kiomoi/City_Palace%2C_Udaipur_7840.jpg")
                        .city(udaipur)
                        .build()));
        hotelRepository.saveAll(List.of(
                Hotel.builder().name("Taj Lake Palace").type("5 Star").nearPlace("Lake Pichola").rating(4.9)
                        .pricePerNight(35000).amenities("WiFi,Pool,Spa,Lake View,Heritage")
                        .imageUrl(
                                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/30/77/ea/4b/royalty-meets-fairy-tale.jpg?w=500&h=-1&s=1")
                        .city(udaipur)
                        .build()));
        foodRepository.saveAll(List.of(
                Food.builder().name("Laal Maas").price(600).isVeg(false).rating(4.7)
                        .description("Fiery red mutton curry with Mathania chillies").category("Main Course")
                        .restaurant("Ambrai").priceRange("₹500-800").mustTry(true)
                        .imageUrl("https://swatisani.net/kitchen/wp-content/uploads/2015/11/IMG_9546.jpg").city(udaipur)
                        .build()));

        // --- Kerala ---
        City kerala = cityRepository.save(City.builder().name("Kerala").state("Kerala").tagline("God's Own Country")
                .description("Backwaters, beaches, and lush greenery").category("Nature").rating(4.8)
                .bestTime("Sep-Mar").language("Malayalam")
                .imageUrl(
                        "https://images.unsplash.com/photo-1602216056096-3b40cc0c9944?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8S0VSQUxBfGVufDB8fDB8fHww")
                .build());
        placeRepository.saveAll(List.of(
                Place.builder().name("Alleppey Backwaters")
                        .description("Network of lagoons and lakes — houseboat capital").category("Nature").rating(4.9)
                        .timings("24 Hours").entryFee("₹1500 (houseboat)")
                        .imageUrl(
                                "https://www.tripsavvy.com/thmb/UoylMLyzOBPdDp34ForEiJd9m3s=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-522478216-5ab12c4e3de4230036949cee.jpg")
                        .city(kerala)
                        .build(),
                Place.builder().name("Munnar").description("Hill station known for tea plantations").category("Nature")
                        .rating(4.7).timings("24 Hours").entryFee("Free")
                        .imageUrl(
                                "https://hblimg.mmtcdn.com/content/hubble/img/destimg/mmt/destination/m_Munnar_main_tv_destination_img_1_l_630_946.jpg")
                        .city(kerala)
                        .build()));
        hotelRepository.saveAll(List.of(
                Hotel.builder().name("Kumarakom Lake Resort").type("5 Star").nearPlace("Backwaters").rating(4.8)
                        .pricePerNight(18000).amenities("WiFi,Pool,Spa,Ayurveda,Lake View")
                        .imageUrl(
                                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/15267976.jpg?k=ccbd56d126e190805d37c39da38a87bf5cce7d758bbf49063d57e18a38adcc73&o=")
                        .city(kerala)
                        .build()));
        foodRepository.saveAll(List.of(
                Food.builder().name("Kerala Sadya").price(300).isVeg(true).rating(4.8)
                        .description("Elaborate vegetarian feast on banana leaf").category("Main Course")
                        .restaurant("Karimeen").priceRange("₹200-400").mustTry(true)
                        .imageUrl("https://upload.wikimedia.org/wikipedia/commons/9/95/Sadhya_DSW.jpg").city(kerala)
                        .build()));

        // --- Mumbai ---
        City mumbai = cityRepository.save(City.builder().name("Mumbai").state("Maharashtra").tagline("City of Dreams")
                .description(
                        "India's financial and entertainment capital. Home to Bollywood, street food culture, colonial-era architecture, and the iconic Marine Drive coastline.")
                .category("Metro").rating(4.5).bestTime("Nov-Feb").language("Hindi, Marathi")
                .imageUrl("https://images.unsplash.com/photo-1570168007204-dfb528c6958f?w=800").build());
        placeRepository.saveAll(List.of(
                Place.builder().name("Gateway of India")
                        .description("Iconic arch monument overlooking the Arabian Sea, built in 1924")
                        .category("Monument").rating(4.7).timings("24 Hours").entryFee("Free")
                        .imageUrl("https://images.unsplash.com/photo-1570168007204-dfb528c6958f?w=400").city(mumbai)
                        .build(),
                Place.builder().name("Marine Drive")
                        .description("3.6 km promenade along the coast, known as Queen's Necklace at night")
                        .category("Landmark").rating(4.8).timings("24 Hours").entryFee("Free")
                        .imageUrl(
                                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/40/ce/c3/mumbai-marine-drive-along.jpg?w=900&h=-1&s=1")
                        .city(mumbai)
                        .build(),
                Place.builder().name("Elephanta Caves")
                        .description("UNESCO rock-cut cave temples on an island in Mumbai Harbour").category("Monument")
                        .rating(4.5).timings("9AM-5PM").entryFee("₹40")
                        .imageUrl(
                                "https://www.tripsavvy.com/thmb/fdxJA_nFNkK77yxMVUudyMPSqIY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Mumbai2019-1-34-b97e159b015d4c989fa265b4b3ac7463.JPG")
                        .city(mumbai)
                        .build()));
        hotelRepository.saveAll(List.of(
                Hotel.builder().name("Taj Mahal Palace").type("5 Star Heritage").nearPlace("Gateway of India")
                        .rating(4.9).pricePerNight(22000).amenities("WiFi,Pool,Spa,Restaurant,Heritage")
                        .imageUrl(
                                "https://cf.bstatic.com/xdata/images/hotel/max1024x768/103705059.jpg?k=9e078265b31ad1815a573da8ed2a665f863e3925e1efd730df703421868a2ada&o=")
                        .city(mumbai)
                        .build(),
                Hotel.builder().name("Trident Nariman Point").type("5 Star").nearPlace("Marine Drive").rating(4.7)
                        .pricePerNight(12000).amenities("WiFi,Pool,Gym,Restaurant")
                        .imageUrl("https://images.unsplash.com/photo-1564501049412-61c2a3083791?w=400").city(mumbai)
                        .build(),
                Hotel.builder().name("FabHotel Colaba").type("Budget").nearPlace("Gateway of India").rating(4.0)
                        .pricePerNight(2200).amenities("WiFi,AC,Restaurant")
                        .imageUrl("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?w=400").city(mumbai)
                        .build()));
        foodRepository.saveAll(List.of(
                Food.builder().name("Vada Pav").price(30).isVeg(true).rating(4.7)
                        .description("Mumbai's iconic spiced potato fritter in a bread bun with chutneys")
                        .category("Street Food").restaurant("Ashok Vada Pav, Kirti College").priceRange("₹20-50")
                        .mustTry(true)
                        .imageUrl("https://www.indianhealthyrecipes.com/wp-content/uploads/2022/10/vada-pav-recipe.jpg")
                        .city(mumbai).build(),
                Food.builder().name("Pav Bhaji").price(120).isVeg(true).rating(4.6)
                        .description("Spiced mashed vegetable curry served with buttered bread rolls")
                        .category("Street Food").restaurant("Sardar Pav Bhaji, Tardeo").priceRange("₹80-150")
                        .mustTry(true).imageUrl("https://images.unsplash.com/photo-1626132647523-66f5bf380027?w=400")
                        .city(mumbai).build(),
                Food.builder().name("Bombay Sandwich").price(80).isVeg(true).rating(4.4)
                        .description("Layered grilled sandwich with chutney, veggies, cheese and butter")
                        .category("Street Food").restaurant("Amar Juice Centre").priceRange("₹60-120").mustTry(true)
                        .imageUrl("https://images.unsplash.com/photo-1528735602780-2552fd46c7af?w=400").city(mumbai)
                        .build()));

        // --- Delhi ---
        City delhi = cityRepository.save(City.builder().name("Delhi").state("Delhi").tagline("Heart of India")
                .description(
                        "India's capital city blending ancient Mughal heritage with modern cosmopolitan culture. Famous for historical monuments, street food paradise, and vibrant markets.")
                .category("Metro").rating(4.4).bestTime("Oct-Mar").language("Hindi, English")
                .imageUrl("https://images.unsplash.com/photo-1587474260584-136574528ed5?w=800").build());
        placeRepository.saveAll(List.of(
                Place.builder().name("Red Fort")
                        .description("UNESCO World Heritage Mughal fort, symbol of India's independence")
                        .category("Fort").rating(4.6).timings("9:30AM-4:30PM").entryFee("₹35")
                        .imageUrl("https://cdn.britannica.com/20/189820-050-D650A54D/Red-Fort-Old-Delhi-India.jpg")
                        .city(delhi)
                        .build(),
                Place.builder().name("Qutub Minar")
                        .description("73m tall UNESCO victory tower, built in 1193 — tallest brick minaret")
                        .category("Monument").rating(4.7).timings("7AM-5PM").entryFee("₹35")
                        .imageUrl(
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQWtgYaY74YrYsi8Y15FAXYI5gZAbCxKUvPw&s")
                        .city(delhi)
                        .build(),
                Place.builder().name("India Gate").description("42m war memorial arch and iconic national landmark")
                        .category("Monument").rating(4.5).timings("24 Hours").entryFee("Free")
                        .imageUrl(
                                "https://cdn.britannica.com/38/189838-050-83C7395E/India-War-Memorial-arch-New-Delhi-Sir.jpg")
                        .city(delhi)
                        .build(),
                Place.builder().name("Chandni Chowk")
                        .description("One of Asia's oldest markets — street food and shopping heaven")
                        .category("Market").rating(4.4).timings("10AM-9PM").entryFee("Free")
                        .imageUrl(
                                "https://s7ap1.scene7.com/is/image/incredibleindia/chandni-chowk-delhi-2-attr-hero?qlt=82&ts=1742170496098")
                        .city(delhi)
                        .build()));
        hotelRepository.saveAll(List.of(
                Hotel.builder().name("The Imperial").type("5 Star Heritage").nearPlace("India Gate").rating(4.8)
                        .pricePerNight(18000).amenities("WiFi,Pool,Spa,Restaurant,Heritage")
                        .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(delhi)
                        .build(),
                Hotel.builder().name("ITC Maurya").type("5 Star").nearPlace("Diplomatic Enclave").rating(4.7)
                        .pricePerNight(14000).amenities("WiFi,Pool,Spa,Gym,Restaurant")
                        .imageUrl("https://images.unsplash.com/photo-1564501049412-61c2a3083791?w=400").city(delhi)
                        .build(),
                Hotel.builder().name("Zostel Delhi").type("Budget").nearPlace("Paharganj").rating(4.1)
                        .pricePerNight(800).amenities("WiFi,AC")
                        .imageUrl("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?w=400").city(delhi)
                        .build()));
        foodRepository.saveAll(List.of(
                Food.builder().name("Chole Bhature").price(100).isVeg(true).rating(4.7)
                        .description("Spicy chickpea curry with fluffy fried bread — quintessential Delhi breakfast")
                        .category("Street Food").restaurant("Sita Ram Diwan Chand, Paharganj").priceRange("₹80-150")
                        .mustTry(true)
                        .imageUrl(
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyta2FEc05FPDkoHtzey9a8nmlgumGb7lDew&s")
                        .city(delhi).build(),
                Food.builder().name("Butter Chicken").price(380).isVeg(false).rating(4.8)
                        .description("Creamy tomato-based chicken curry, invented in Delhi — loved worldwide")
                        .category("Main Course").restaurant("Moti Mahal, Daryaganj").priceRange("₹300-500")
                        .mustTry(true).imageUrl("https://images.unsplash.com/photo-1603894584373-5ac82b2ae398?w=400")
                        .city(delhi).build(),
                Food.builder().name("Paranthe Wali Gali Paratha").price(80).isVeg(true).rating(4.5)
                        .description("Stuffed flatbread from the legendary lane in Old Delhi since 1872")
                        .category("Street Food").restaurant("Paranthe Wali Gali").priceRange("₹50-120").mustTry(true)
                        .imageUrl(
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpeX7F-PYvh4U-veL02WMpSXf3OeQfOTNPbw&s")
                        .city(delhi)
                        .build()));

        // --- Agra ---
        City agra = cityRepository.save(City.builder().name("Agra").state("Uttar Pradesh").tagline("City of the Taj")
                .description(
                        "Home to the Taj Mahal — one of the Seven Wonders of the World. A city of Mughal grandeur with magnificent forts, tombs, and the finest marble craftsmanship.")
                .category("Heritage").rating(4.6).bestTime("Oct-Mar").language("Hindi")
                .imageUrl("https://images.unsplash.com/photo-1564507592333-c60657eea523?w=800").build());
        placeRepository.saveAll(List.of(
                Place.builder().name("Taj Mahal")
                        .description("UNESCO ivory-white marble mausoleum — one of the Seven Wonders of the World")
                        .category("Monument").rating(5.0).timings("6AM-6:30PM (Closed Fridays)")
                        .entryFee("₹50 (Indian), ₹1100 (Foreign)")
                        .imageUrl("https://images.unsplash.com/photo-1564507592333-c60657eea523?w=400").city(agra)
                        .build(),
                Place.builder().name("Agra Fort")
                        .description("UNESCO red sandstone fortress — seat of Mughal emperors for generations")
                        .category("Fort").rating(4.7).timings("6AM-6PM").entryFee("₹50")
                        .imageUrl(
                                "https://kevinstandagephotography.wordpress.com/wp-content/uploads/2019/05/cover-3.jpg")
                        .city(agra)
                        .build(),
                Place.builder().name("Fatehpur Sikri")
                        .description("UNESCO ghost city — Akbar's abandoned Mughal capital, stunning architecture")
                        .category("Monument").rating(4.6).timings("6AM-6PM").entryFee("₹50")
                        .imageUrl(
                                "https://i0.wp.com/somanytraveltales.com/wp-content/uploads/2021/12/Anup-Talao-2-Fatehpur-1-scaled.jpg?fit=1024%2C697&ssl=1")
                        .city(agra)
                        .build()));
        hotelRepository.saveAll(List.of(
                Hotel.builder().name("The Oberoi Amarvilas").type("5 Star").nearPlace("Taj Mahal").rating(4.9)
                        .pricePerNight(30000).amenities("WiFi,Pool,Spa,Restaurant,Heritage")
                        .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(agra)
                        .build(),
                Hotel.builder().name("Radisson Blu Agra").type("4 Star").nearPlace("Taj Mahal").rating(4.5)
                        .pricePerNight(5500).amenities("WiFi,Pool,Restaurant,Gym")
                        .imageUrl("https://images.unsplash.com/photo-1564501049412-61c2a3083791?w=400").city(agra)
                        .build(),
                Hotel.builder().name("Hotel Sidhartha").type("Budget").nearPlace("Taj Mahal").rating(3.8)
                        .pricePerNight(1200).amenities("WiFi,AC,Restaurant")
                        .imageUrl("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?w=400").city(agra)
                        .build()));
        foodRepository.saveAll(List.of(
                Food.builder().name("Petha").price(200).isVeg(true).rating(4.3)
                        .description("Agra's famous translucent soft candy made from ash gourd — iconic souvenir sweet")
                        .category("Sweet").restaurant("Panchhi Petha, Sadar Bazaar").priceRange("₹100-400/kg")
                        .mustTry(true)
                        .imageUrl(
                                "https://omsweets.in/cdn/shop/files/DryPetha.jpg?crop=center&height=2048&v=1756528182&width=2048")
                        .city(agra).build(),
                Food.builder().name("Mughlai Biryani").price(350).isVeg(false).rating(4.6)
                        .description("Rich, aromatic rice dish with spiced meat — Mughal culinary legacy")
                        .category("Main Course").restaurant("Pinch of Spice").priceRange("₹250-500").mustTry(true)
                        .imageUrl("https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?w=400").city(agra)
                        .build(),
                Food.builder().name("Bedai & Jalebi").price(60).isVeg(true).rating(4.5)
                        .description("Crispy fried bread with spicy dal, paired with sugary jalebi — classic breakfast")
                        .category("Street Food").restaurant("Deviram Sweets").priceRange("₹40-80").mustTry(true)
                        .imageUrl(
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbt6ni8kA02eE0EgCxjiyB3yLMErjZizPf6Q&s")
                        .city(agra)
                        .build()));

        // --- Rishikesh ---
        City rishikesh = cityRepository.save(City.builder().name("Rishikesh").state("Uttarakhand")
                .tagline("Yoga Capital of the World")
                .description(
                        "Sacred town on the banks of the Ganges, renowned worldwide for yoga, meditation, and white-water rafting. Where The Beatles came to meditate in 1968.")
                .category("Nature").rating(4.6).bestTime("Sep-Nov, Mar-May").language("Hindi")
                .imageUrl(
                        "https://media.istockphoto.com/id/655235152/photo/hindu-god-statue-lord-shiva-sculpture-sitting-in-meditation-india-2011.webp?a=1&b=1&s=612x612&w=0&k=20&c=OGj9cjEJ3Q5T9pRGCLZRj66S-pGmdKase3ZqFNSNRb0=")
                .build());
        placeRepository.saveAll(List.of(
                Place.builder().name("Laxman Jhula")
                        .description("Iconic 137m suspension bridge over the Ganges, surrounded by temples")
                        .category("Landmark").rating(4.6).timings("24 Hours").entryFee("Free")
                        .imageUrl("https://imgs.search.brave.com/o5aZWBR4ApTdijUKky45f1kxFsCKYc_nn-TKOTxfY7g/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/Y2hhcmRoYW10b3Vy/LmluL2Jsb2cvd3At/Y29udGVudC91cGxv/YWRzLzIwMjAvMDEv/TGF4bWFuLUpodWxh/LVJpc2hpa2VzaC5q/cGc").city(rishikesh)
                        .build(),
                Place.builder().name("Beatles Ashram").description(
                        "Abandoned meditation ashram where The Beatles stayed in 1968 — now a cultural landmark")
                        .category("Monument").rating(4.5).timings("9AM-4PM").entryFee("₹150")
                        .imageUrl("https://imgs.search.brave.com/dFgjtQnbnbTcF_t-GaBPtKfSAKQ1Vo4lYiS7779YB2U/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly90My5m/dGNkbi5uZXQvanBn/LzAzLzc0LzgyLzk2/LzM2MF9GXzM3NDgy/OTYwNl9iUjc4SHZk/MmJQOU1udDdEZzZZ/Ym9WdTQyT2hPMk9j/VS5qcGc").city(rishikesh)
                        .build(),
                Place.builder().name("Triveni Ghat")
                        .description("Sacred bathing ghat at the confluence of three rivers — evening Ganga Aarti")
                        .category("Temple").rating(4.7).timings("5AM-9PM").entryFee("Free")
                        .imageUrl("https://imgs.search.brave.com/OCCFJjUlh9s5s446mYkGZJO1-2AzygW8S798FhESkNc/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9lbGVt/ZW50cy1yZXNpemVk/LmVudmF0b3VzZXJj/b250ZW50LmNvbS9l/bGVtZW50cy12aWRl/by1jb3Zlci1pbWFn/ZXMvYWI3ZTRhZTQt/MTVmZS00ZjA1LTg1/ZjItMDFiMDM1MDk4/NDFlL3ZpZGVvX3By/ZXZpZXcvdmlkZW9f/cHJldmlld18wMDAw/LmpwZz93PTUwMCZj/Zl9maXQ9Y292ZXIm/cT04NSZmb3JtYXQ9/YXV0byZzPTc3NzA3/YmY3ZDJiOTU2NWI5/NDc1YzIzYjg5NGYw/Yjk2MDI5ZDc3MDgx/YjA4ODY3Y2MzNGU1/MTE0NmYwZGRjNTc").city(rishikesh)
                        .build()));
        hotelRepository.saveAll(List.of(
                Hotel.builder().name("Aloha on the Ganges").type("4 Star").nearPlace("Laxman Jhula").rating(4.6)
                        .pricePerNight(7000).amenities("WiFi,Pool,Spa,Restaurant,River View")
                        .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(rishikesh)
                        .build(),
                Hotel.builder().name("Zostel Rishikesh").type("Budget").nearPlace("Laxman Jhula").rating(4.3)
                        .pricePerNight(600).amenities("WiFi,River View,Bonfire")
                        .imageUrl("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4?w=400").city(rishikesh)
                        .build()));
        foodRepository.saveAll(List.of(
                Food.builder().name("Aloo Puri").price(60).isVeg(true).rating(4.4)
                        .description("Deep-fried bread with spiced potato curry — classic North Indian breakfast")
                        .category("Street Food").restaurant("Chotiwala, Swarg Ashram").priceRange("₹50-80")
                        .mustTry(true).imageUrl("https://imgs.search.brave.com/tVtJ97tsZPNUDndmDQmL9FVpd6or3-aGfN8wV4nRpRE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWcu/ZnJlZXBpay5jb20v/ZnJlZS1waG90by9k/ZWxpY2lvdXMtcGxh/dGUtY2hvbGUtYmhh/dHVyZS1pbmRpYW4t/Y3VsaW5hcnktZGVs/aWdodF8yMy0yMTUx/OTk4NTg1LmpwZz9z/ZW10PWFpc19oeWJy/aWQmdz03NDAmcT04/MA")
                        .city(rishikesh).build(),
                Food.builder().name("Fresh Fruit Smoothie Bowl").price(200).isVeg(true).rating(4.2)
                        .description("Healthy organic bowls with seasonal Himalayan fruits — yoga town favourite")
                        .category("Drink").restaurant("The 60's Cafe").priceRange("₹150-250").mustTry(false)
                        .imageUrl("https://imgs.search.brave.com/ozgAkJ0ZxtYBi6Qzjx4YkqKg8H_Rl4SSPZOatr7yB5M/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdGF0/aWMudmVjdGVlenku/Y29tL3N5c3RlbS9y/ZXNvdXJjZXMvdGh1/bWJuYWlscy8wNjAv/MTE3LzE3Ni9zbWFs/bC9yZWZyZXNoaW5n/LWhlYWx0aHktZnJ1/aXQtc21vb3RoaWVz/LW1hZGUtd2l0aC1m/cmVzaC1mcnVpdHMt/dmVnZXRhYmxlcy1w/aG90by5qcGc").city(rishikesh)
                        .build()));

        // --- Mysore ---
        City mysore = cityRepository.save(City.builder().name("Mysore").state("Karnataka").tagline("City of Palaces")
                .description(
                        "Cultural capital of Karnataka with stunning palaces, silk sarees, and the famous Dasara festival.")
                .category("Heritage").rating(4.6).bestTime("Oct-Feb").language("Kannada")
                .imageUrl(
                        "https://media.istockphoto.com/id/172126084/photo/somanathpur-temple-mysore-india.jpg?s=1024x1024&w=is&k=20&c=EcDlymf4-cIhANmuFI44rE6kTTornL5_nztrKYHDM1I=")
                .build());
        placeRepository.saveAll(List.of(Place.builder().name("Mysore Palace")
                .description("Magnificent royal palace with Indo-Saracenic architecture, lit with 100,000 bulbs")
                .category("Palace").rating(4.8).timings("10AM-5:30PM").entryFee("₹70")
                .imageUrl("https://imgs.search.brave.com/cS9OzF-jouM97nWNi_XGRqYjK_LGLANh-RgEajBxKIo/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pMC53/cC5jb20vdGhldW5z/dHVtYmxlZC5jb20v/d3AtY29udGVudC91/cGxvYWRzLzIwMjUv/MDkvTXlzb3JlLURh/c2FyYS0yMDI1Lmpw/Zz9maXQ9MTIwMCw4/MDAmc3NsPTE").city(mysore).build()));
        hotelRepository.save(Hotel.builder().name("Radisson Blu Plaza Mysore").type("5 Star").nearPlace("Mysore Palace")
                .rating(4.5).pricePerNight(6500).amenities("WiFi,Pool,Restaurant,Gym")
                .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(mysore).build());
        foodRepository.save(Food.builder().name("Mysore Pak").price(120).isVeg(true).rating(4.6)
                .description("Iconic ghee-rich sweet made from besan — invented in the Mysore Palace kitchen")
                .category("Sweet").restaurant("Guru Sweet Mart").priceRange("₹80-200").mustTry(true)
                .imageUrl("https://imgs.search.brave.com/i_QXW4GvMU8N_XlMrm5ilboWa7-TPT_3Akpr4qEoJtw/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zdDEu/bGF0ZXN0bHkuY29t/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDIz/LzA1L015c29yZS1Q/YWstUGhvdG8tMi5q/cGc").city(mysore).build());

        // --- Amritsar ---
        City amritsar = cityRepository.save(City.builder().name("Amritsar").state("Punjab").tagline("Golden Glory")
                .description(
                        "Spiritual and cultural hub of Punjab, home to the Golden Temple and legendary Punjabi cuisine.")
                .category("Heritage").rating(4.7).bestTime("Oct-Mar").language("Punjabi, Hindi")
                .imageUrl("https://images.unsplash.com/photo-1514222134-b57cbb8ce073?w=800").build());
        placeRepository.save(Place.builder().name("Golden Temple")
                .description("Holiest shrine of Sikhism — stunning gold-plated gurdwara with sacred pool")
                .category("Temple").rating(5.0).timings("24 Hours").entryFee("Free")
                .imageUrl("https://images.unsplash.com/photo-1514222134-b57cbb8ce073?w=400").city(amritsar).build());
        hotelRepository.save(Hotel.builder().name("Hyatt Amritsar").type("5 Star").nearPlace("Golden Temple")
                .rating(4.6).pricePerNight(8000).amenities("WiFi,Pool,Spa,Restaurant")
                .imageUrl("https://imgs.search.brave.com/1o-3aQNNcFgjex0do2dJ4-u8m1V4gm7aR1k_1gjJqdw/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMudHJ2bC1tZWRp/YS5jb20vbG9kZ2lu/Zy8zMDAwMDAwLzIz/OTAwMDAvMjM4NDQw/MC8yMzg0MzgzLzc3/MWVhYjkzLmpwZz9p/bXBvbGljeT1yZXNp/emVjcm9wJnJ3PTI5/NyZyYT1maXQ").city(amritsar).build());
        foodRepository.save(Food.builder().name("Amritsari Kulcha").price(100).isVeg(true).rating(4.7)
                .description("Stuffed flatbread with spiced potato filling, served with chole — Punjab's pride")
                .category("Street Food").restaurant("Kesar Da Dhaba").priceRange("₹80-150").mustTry(true)
                .imageUrl("https://imgs.search.brave.com/xl0u7-pHoo8Q_SVAhpV-q9AQjSCcTAKYtSL9TsBgOpE/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9yZXMu/Y2xvdWRpbmFyeS5j/b20vcHVybmVzaC9p/bWFnZS91cGxvYWQv/d18xMDAwLGZfYXV0/byxxX2F1dG86ZWNv/LGNfbGltaXQvYWxs/LWluZGlhLWZhbW91/cy1hbXJpdHNhcmkt/a3VsY2hhNDQxODIu/anBn").city(amritsar).build());

        // --- Darjeeling ---
        City darjeeling = cityRepository.save(City.builder().name("Darjeeling").state("West Bengal")
                .tagline("Queen of Hills")
                .description(
                        "Himalayan hill station famous for tea gardens, the Toy Train, and stunning Kanchenjunga views.")
                .category("Mountain").rating(4.6).bestTime("Mar-May, Oct-Nov").language("Bengali, Nepali")
                .imageUrl(
                        "https://images.unsplash.com/photo-1696426886039-a3b5c8774e3d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fGRhcmplZWxpbmd8ZW58MHx8MHx8fDA%3D")
                .build());
        placeRepository.save(Place.builder().name("Tiger Hill")
                .description("Best viewpoint for sunrise over Kanchenjunga — 3rd highest peak in the world")
                .category("Nature").rating(4.7).timings("4AM-6AM").entryFee("₹30")
                .imageUrl("https://imgs.search.brave.com/NIRHC-z_dYkXS-jNge2QvQLd3r3OQL_h40fNegEAnbo/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9zN2Fw/MS5zY2VuZTcuY29t/L2lzL2ltYWdlL2lu/Y3JlZGlibGVpbmRp/YS90aWdlci1oaWxs/LWRhcmplZWxpbmct/d2VzdC1iZW5nYWwt/My1hdHRyLWhlcm8_/cWx0PTgyJnRzPTE3/MjY2NDMxODkyNDg").city(darjeeling)
                .build());
        hotelRepository.save(Hotel.builder().name("Mayfair Darjeeling").type("4 Star").nearPlace("Mall Road")
                .rating(4.5).pricePerNight(7500).amenities("WiFi,Restaurant,Mountain View,Fireplace")
                .imageUrl("https://imgs.search.brave.com/VzTWE4bfTXj7NRbmefK10Rwzc3EPvUG3T0iY2Gb0-ew/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9hc3Nl/dHMuc2ltcGxvdGVs/LmNvbS9zaW1wbG90/ZWwvaW1hZ2UvdXBs/b2FkL3hfMCx5Xzc0/LHdfMTUwMCxoXzg0/NCxyXzAsY19jcm9w/L3FfODAsd185MDAs/ZHByXzEsZl9hdXRv/LGZsX3Byb2dyZXNz/aXZlLGNfbGltaXQv/bWF5ZmFpci1oaWxs/LXJlc29ydC1kYXJq/ZWVsaW5nL0VYVDJf/d3UzemR5").city(darjeeling)
                .build());
        foodRepository.save(Food.builder().name("Darjeeling Momos").price(80).isVeg(false).rating(4.5)
                .description("Steamed dumplings stuffed with pork or vegetables — Himalayan soul food")
                .category("Street Food").restaurant("Kunga Restaurant").priceRange("₹60-120").mustTry(true)
                .imageUrl("https://images.unsplash.com/photo-1534422298391-e4f8c172dddb?w=400").city(darjeeling)
                .build());

        // --- Shimla ---
        City shimla = cityRepository.save(City.builder().name("Shimla").state("Himachal Pradesh")
                .tagline("Queen of Hill Stations")
                .description(
                        "Former summer capital of British India. Colonial architecture, pine forests, and panoramic Himalayan views.")
                .category("Mountain").rating(4.5).bestTime("Mar-Jun, Dec-Feb").language("Hindi, Pahari")
                .imageUrl("https://images.unsplash.com/photo-1597074866923-dc0589150358?w=800").build());
        placeRepository.save(Place.builder().name("The Ridge")
                .description(
                        "Open space in the heart of Shimla with views of surrounding mountains and colonial buildings")
                .category("Landmark").rating(4.5).timings("24 Hours").entryFee("Free")
                .imageUrl("https://images.unsplash.com/photo-1597074866923-dc0589150358?w=400").city(shimla).build());
        hotelRepository.save(Hotel.builder().name("Wildflower Hall, Oberoi").type("5 Star").nearPlace("The Ridge")
                .rating(4.8).pricePerNight(25000).amenities("WiFi,Pool,Spa,Restaurant,Mountain View")
                .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(shimla).build());
        foodRepository.save(Food.builder().name("Chana Madra").price(150).isVeg(true).rating(4.3)
                .description("Chickpeas cooked in yogurt gravy with Himachali spices — local comfort food")
                .category("Main Course").restaurant("Wake & Bake Cafe").priceRange("₹120-200").mustTry(true)
                .imageUrl("https://images.picxy.com/cache/2020/8/2/ed6683cad36b69f82ed539f850aa16ad.jpg").city(shimla).build());

        // --- Kolkata ---
        City kolkata = cityRepository.save(City.builder().name("Kolkata").state("West Bengal").tagline("City of Joy")
                .description(
                        "India's cultural capital known for literature, art, Durga Puja, and the sweetest sweets in India.")
                .category("Metro").rating(4.4).bestTime("Oct-Mar").language("Bengali, English")
                .imageUrl(
                        "https://images.unsplash.com/photo-1716470061387-d32570b54e69?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mzh8fEtPTEtBVEF8ZW58MHx8MHx8fDA%3D")
                .build());
        placeRepository.save(Place.builder().name("Victoria Memorial")
                .description("Grand marble building from British era — museum surrounded by lush gardens")
                .category("Monument").rating(4.7).timings("10AM-6PM").entryFee("₹30")
                .imageUrl("https://images.unsplash.com/photo-1558431382-27e303142255?w=400").city(kolkata).build());
        hotelRepository.save(Hotel.builder().name("The Oberoi Grand").type("5 Star Heritage").nearPlace("Park Street")
                .rating(4.8).pricePerNight(12000).amenities("WiFi,Pool,Spa,Restaurant,Heritage")
                .imageUrl("https://imgs.search.brave.com/33vrKBKbOMdKMHE620nukDRxR_-DNsU-tDybymhimBk/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZi5i/c3RhdGljLmNvbS94/ZGF0YS9pbWFnZXMv/aG90ZWwvbWF4NTAw/LzQ2NDMzMDY3Lmpw/Zz9rPTVmMDNiYjdm/ZmJhM2I4ZTk3MzNm/ZjIzNGQ3N2E2ZDQ3/ZTEzNjNmOGY3ZWIx/ZWI0Y2NjZGUwN2Rl/Y2NmYTMyMzAmbz0m/aHA9MQ").city(kolkata).build());
        foodRepository.save(Food.builder().name("Rosogolla").price(60).isVeg(true).rating(4.7)
                .description("Spongy cottage cheese balls soaked in sugar syrup — Bengal's gift to the world")
                .category("Sweet").restaurant("K.C. Das").priceRange("₹50-100").mustTry(true)
                .imageUrl("https://imgs.search.brave.com/EItOF7x8VQK5Plb3gr7AsBcymP8hSsxWsfZkQEJ-HAM/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9ibG9n/Z2VyLmdvb2dsZXVz/ZXJjb250ZW50LmNv/bS9pbWcvYi9SMjl2/WjJ4bC9BVnZYc0Vn/U09COS1ITnRiVTV1/TGhlNVJlSHcxbElX/YzRZR3pqOEU1YTNG/dWFiN2JpQ0FsdXpX/Q2pHbDF5blVhbkQ5/RUVwbWdVVmJmVENL/c1RDQ3hSZmVwbVB4/ZlhzR3hTS1RWTTN5/b1JHZ2ZIOExuaFVH/ZkJLbHBaM1FwQU1r/SGlpaEo0VDdubUZL/cFEyV0FyM3FxL3M4/MDAvcm9zb2dvbGxh/Mi5qcGc").city(kolkata).build());

        // --- Hyderabad ---
        City hyderabad = cityRepository.save(City.builder().name("Hyderabad").state("Telangana")
                .tagline("City of Pearls")
                .description(
                        "Tech hub with Mughal heritage, famous for Charminar, Birla Mandir, and the world's best biryani.")
                .category("Metro").rating(4.5).bestTime("Oct-Mar").language("Telugu, Urdu")
                .imageUrl(
                        "https://images.unsplash.com/photo-1551161242-b5af797b7233?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8SFlERVJBQkFEfGVufDB8fDB8fHww")
                .build());
        placeRepository.save(Place.builder().name("Charminar")
                .description("Iconic 16th-century mosque with four grand arches — symbol of Hyderabad")
                .category("Monument").rating(4.6).timings("9:30AM-5:30PM").entryFee("₹25")
                .imageUrl("https://imgs.search.brave.com/mY-l_ce6xu4f5Fe7C0LYGPjwZ2o1dDxAlz5U8qEpFaI/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9oeWRl/cmFiYWR0b3VycGFj/a2FnZS5pbi9pbWFn/ZXMvcGxhY2VzLXRv/LXZpc2l0L2NoYXJt/aW5hci1oeWRlcmFi/YWQtZW50cnlmZWUt/dGltaW5ncy10b3Vy/LXBhY2thZ2UtaGVh/ZGVyLmpwZw").city(hyderabad)
                .build());
        hotelRepository.save(Hotel.builder().name("Taj Falaknuma Palace").type("5 Star Heritage").nearPlace("Charminar")
                .rating(4.9).pricePerNight(28000).amenities("WiFi,Pool,Spa,Restaurant,Heritage")
                .imageUrl("https://imgs.search.brave.com/PX1n9bF51B4DMCYaWP9VRywebqx-DvYqjQfX3unWtkE/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9oZWxs/b2h5ZGVyYWJhZC5v/cmcvd3AtY29udGVu/dC91cGxvYWRzLzIw/MjQvMDcvVW50aXRs/ZWQtZGVzaWduLTQt/MS5qcGc").city(hyderabad)
                .build());
        foodRepository.save(Food.builder().name("Hyderabadi Biryani").price(280).isVeg(false).rating(4.9)
                .description("Slow-cooked dum biryani with aromatic spices — rated world's best rice dish")
                .category("Main Course").restaurant("Paradise Biryani").priceRange("₹200-400").mustTry(true)
                .imageUrl("https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?w=400").city(hyderabad)
                .build());

        // --- Jaisalmer ---
        City jaisalmer = cityRepository.save(City.builder().name("Jaisalmer").state("Rajasthan")
                .tagline("The Golden City")
                .description(
                        "Living sandcastle fort rising from the Thar Desert, known for sand dunes, camel safaris, and havelis.")
                .category("Heritage").rating(4.7).bestTime("Oct-Mar").language("Hindi, Rajasthani")
                .imageUrl("https://images.unsplash.com/photo-1586612438666-ffd0ae97ad36?w=800").build());
        placeRepository.save(Place.builder().name("Jaisalmer Fort")
                .description("UNESCO living fort — one of the largest fully preserved fortified cities in the world")
                .category("Fort").rating(4.8).timings("9AM-6PM").entryFee("₹100")
                .imageUrl("https://images.unsplash.com/photo-1586612438666-ffd0ae97ad36?w=400").city(jaisalmer)
                .build());
        hotelRepository.save(Hotel.builder().name("Suryagarh Jaisalmer").type("5 Star").nearPlace("Sam Sand Dunes")
                .rating(4.8).pricePerNight(15000).amenities("WiFi,Pool,Spa,Restaurant,Heritage")
                .imageUrl("https://imgs.search.brave.com/LhhQLfPQp31ExOJR2yCUAq25RlSk9aN4MzRhmoXQ_YE/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/bXlldmVudHouY28u/aW4vcHVibGljL3Vw/bG9hZHMvdmVudWVf/MjgzL3Jvb21zXzAv/U3VyeWFnYXJoJTIw/SmFpc2FsbWVyJTIw/VGhhciUyMEhhdmVs/aS5qcGc").city(jaisalmer)
                .build());
        foodRepository.save(Food.builder().name("Ker Sangri").price(200).isVeg(true).rating(4.4)
                .description("Traditional desert vegetable dish made from indigenous desert beans and berries")
                .category("Main Course").restaurant("Desert Boy's Dhani").priceRange("₹150-300").mustTry(true)
                .imageUrl("https://imgs.search.brave.com/0iAlSggxqm5Idk-7V_OJOdIUDarKXmLNun2OFwFjozo/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/Zm9vZGllLXRyYWls/LmNvbS93cC1jb250/ZW50L3VwbG9hZHMv/MjAyMS8xMS8yMDIx/MTEwM18xNDQ3NDI4/ODRfaU9TLXNjYWxl/ZC5qcGc").city(jaisalmer)
                .build());

        // --- Ooty ---
        City ooty = cityRepository.save(City.builder().name("Ooty").state("Tamil Nadu").tagline("Queen of the Nilgiris")
                .description(
                        "Enchanting hill station with tea plantations, botanical gardens, and the iconic Nilgiri Mountain Railway.")
                .category("Mountain").rating(4.5).bestTime("Oct-Jun").language("Tamil, English")
                .imageUrl("https://imgs.search.brave.com/Ddbvbe9YveCwfbw4yxXLAHxhmtffN2mtoC-zovpKMLs/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTYy/MzMxODExL3Bob3Rv/L2F2YWxhbmNoZS1s/YWtlLmpwZz9zPTYx/Mng2MTImdz0wJms9/MjAmYz1DRElQQlFG/bGdVVHBaT1hDaXRC/WE1iVGJsd0FkdDFq/YWl3am5wUlpYQk5R/PQ").build());
        placeRepository.save(Place.builder().name("Ooty Botanical Gardens")
                .description("150-year-old gardens with 650+ plant species including a 20-million-year-old fossil tree")
                .category("Nature").rating(4.5).timings("8AM-6:30PM").entryFee("₹30")
                .imageUrl("https://imgs.search.brave.com/E73M53O-EbI4E40hIcv9OHS152FbKMIAOM3CzAj4kbg/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvY29tbW9ucy9j/L2MxL0JvdGFuaWNh/bF9HYXJkZW5zXy1f/T290YWNhbXVuZF8o/T290eSlfLV9JbmRp/YV8wMy5KUEc").city(ooty).build());
        hotelRepository.save(Hotel.builder().name("Savoy IHCL").type("5 Star Heritage").nearPlace("Botanical Gardens")
                .rating(4.6).pricePerNight(9000).amenities("WiFi,Restaurant,Heritage,Fireplace")
                .imageUrl("https://imgs.search.brave.com/I6jRkrz8v-OngGp887eKLpZtJNQSpSMZdP9cXtIyoxs/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9jZi5i/c3RhdGljLmNvbS94/ZGF0YS9pbWFnZXMv/aG90ZWwvbWF4MTIw/MC8yNTQxNzI0NzEu/anBnP2s9MzVkNmE4/ZjNlNjVjYTQwNzVk/YjViMWFlMTI2MzA1/ODQzNzBiMTRlNzhk/OGM5NDUyMGYwNmJm/NDA0MzY3NGZhYyZv/PQ").city(ooty).build());
        foodRepository.save(Food.builder().name("Ooty Chocolate").price(250).isVeg(true).rating(4.5)
                .description("Handcrafted artisan chocolate made from Nilgiri cocoa — famous hill station souvenir")
                .category("Sweet").restaurant("King Star Chocolate").priceRange("₹100-500").mustTry(true)
                .imageUrl("https://images.unsplash.com/photo-1549007994-cb92caebd54b?w=400").city(ooty).build());

        // --- Pondicherry ---
        City pondicherry = cityRepository.save(City.builder().name("Pondicherry").state("Puducherry")
                .tagline("French Riviera of the East")
                .description(
                        "Charming coastal town with French colonial architecture, serene beaches, Auroville, and vibrant cafes.")
                .category("Beach").rating(4.5).bestTime("Oct-Mar").language("Tamil, French, English")
                .imageUrl("https://images.unsplash.com/photo-1582510003544-4d00b7f74220?w=800").build());
        placeRepository.save(Place.builder().name("Promenade Beach")
                .description("1.5km seafront walkway lined with colonial buildings, statues, and cafes")
                .category("Beach").rating(4.5).timings("24 Hours").entryFee("Free")
                .imageUrl("https://imgs.search.brave.com/5dbvSpCFi_pGC5IqLpgeVI41q8njyPDSDr4HJlMuxXw/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly92aXNp/dHBsYWNlc2luZGlh/LmNvbS93cC1jb250/ZW50L3VwbG9hZHMv/MjAyNC8xMS9wcm9t/ZW5hZGUtYmVhY2gt/cHVkdWNoZXJyeS5q/cGc").city(pondicherry)
                .build());
        hotelRepository.save(Hotel.builder().name("Palais de Mahe").type("4 Star Boutique").nearPlace("Promenade Beach")
                .rating(4.6).pricePerNight(7000).amenities("WiFi,Pool,Restaurant,Heritage")
                .imageUrl("https://imgs.search.brave.com/ncSYWEpUe6hQ4Z39InPU_NKk07CfmXmFgfZwZx3hR1E/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMuc2NvdHRkdW5u/LmNvbS9jX2ZpbGws/Zl9hdXRvLHFfYXV0/byxoXzkwMCx3XzEz/NTAvaW5kaWEvYWNj/b21tb2RhdGlvbi9w/YWxhaXMtZGUtbWFo/ZS83MzA1NjAtY29y/cmlkb3ItcGFsYWlz/LWRlLW1haGUtdGFt/aWwtbmFkdS1pbmRp/YS1pbmRpYW4tc3Vi/LWNvbnRpbmVudC1h/c2lhLmpwZWc").city(pondicherry)
                .build());
        foodRepository.save(Food.builder().name("Pondicherry Filter Coffee").price(50).isVeg(true).rating(4.6)
                .description("Strong South Indian filter coffee with French twist — served in colonial cafes")
                .category("Drink").restaurant("Cafe des Arts").priceRange("₹30-80").mustTry(true)
                .imageUrl("https://imgs.search.brave.com/jbZW-J_A21f7O3S9B05oYIzcVEOJmBJAs4H_Bz2SGes/rs:fit:500:0:1:0/g:ce/aHR0cHM6Ly93d3cu/c2h1dHRlcnN0b2Nr/LmNvbS9pbWFnZS1w/aG90by9pbmRpYW4t/ZmlsdGVyLWNvZmZl/ZS1zZXJ2ZWQtYnJh/c3MtMjYwbnctMTMx/NTk2OTQ2Ni5qcGc").city(pondicherry)
                .build());

        // --- Leh-Ladakh ---
        City leh = cityRepository.save(City.builder().name("Leh-Ladakh").state("Ladakh").tagline("Land of High Passes")
                .description(
                        "Breathtaking high-altitude desert with Buddhist monasteries, pristine lakes, and the world's highest motorable roads.")
                .category("Mountain").rating(4.9).bestTime("Jun-Sep").language("Ladakhi, Hindi")
                .imageUrl(
                        "https://plus.unsplash.com/premium_photo-1661962344178-19930ba15492?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8TEVILUxBREFLSHxlbnwwfHwwfHx8MA%3D%3D")
                .build());
        placeRepository.save(Place.builder().name("Pangong Lake")
                .description("Stunning 134km high-altitude lake changing colors through the day — featured in 3 Idiots")
                .category("Nature").rating(4.9).timings("24 Hours").entryFee("₹400 (permit)")
                .imageUrl("https://images.unsplash.com/photo-1606857090627-27ca46667290?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGFuZ29uZyUyMGxha2V8ZW58MHx8MHx8fDA%3D").city(leh).build());
        hotelRepository.save(Hotel.builder().name("The Grand Dragon Ladakh").type("4 Star").nearPlace("Leh Market")
                .rating(4.5).pricePerNight(8000).amenities("WiFi,Restaurant,Mountain View")
                .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(leh).build());
        foodRepository.save(Food.builder().name("Thukpa").price(150).isVeg(false).rating(4.5)
                .description("Hearty Ladakhi noodle soup with vegetables and meat — perfect for high altitude")
                .category("Main Course").restaurant("Tibetan Kitchen").priceRange("₹100-200").mustTry(true)
                .imageUrl("https://media.istockphoto.com/id/2263127123/photo/fresh-keema-noodles-topped-with-minced-meat-and-vegetables-served-at-a-local-eatery-in.webp?a=1&b=1&s=612x612&w=0&k=20&c=SifbLhFD49ztDnqewkQFhCWtZgLbLIsGFH0tu52A3rM=").city(leh).build());

        // --- Jodhpur ---
        City jodhpur = cityRepository.save(City.builder().name("Jodhpur").state("Rajasthan").tagline("The Blue City")
                .description(
                        "City of blue-painted houses beneath the mighty Mehrangarh Fort — Rajasthan's second largest city.")
                .category("Heritage").rating(4.6).bestTime("Oct-Mar").language("Hindi, Marwari")
                .imageUrl(
                        "https://images.unsplash.com/photo-1669548329838-45008f9a45fc?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fEpPREhQVVJ8ZW58MHx8MHx8fDA%3D")
                .build());
        placeRepository.save(Place.builder().name("Mehrangarh Fort")
                .description("One of India's largest forts perched 125m above the city — museums and panoramic views")
                .category("Fort").rating(4.8).timings("9AM-5PM").entryFee("₹100")
                .imageUrl("https://images.unsplash.com/photo-1567771971104-545efaf89ddb?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8bWVocmFuZ2FyaCUyMGZvcnR8ZW58MHx8MHx8fDA%3D").city(jodhpur).build());
        hotelRepository.save(Hotel.builder().name("Umaid Bhawan Palace").type("5 Star Heritage")
                .nearPlace("Mehrangarh Fort").rating(4.9).pricePerNight(38000)
                .amenities("WiFi,Pool,Spa,Restaurant,Heritage")
                .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(jodhpur).build());
        foodRepository.save(Food.builder().name("Mirchi Bada").price(30).isVeg(true).rating(4.4)
                .description("Deep-fried green chili fritter stuffed with spicy potato filling — fiery street snack")
                .category("Street Food").restaurant("Shahi Samosa").priceRange("₹20-40").mustTry(true)
                .imageUrl("https://media.istockphoto.com/id/1323631715/photo/indian-street-food-snacks-mirchi-bhaji-pakora-and-bonda-in-market.webp?a=1&b=1&s=612x612&w=0&k=20&c=MnlldW9inUSjhxDulVZbmAvxsGUfwnjxWKN_wgji9eY=").city(jodhpur).build());

        // --- Hampi ---
        City hampi = cityRepository.save(City.builder().name("Hampi").state("Karnataka").tagline("City of Ruins")
                .description(
                        "UNESCO World Heritage Site with magnificent ruins of the Vijayanagara Empire — a boulder-strewn wonderland.")
                .category("Heritage").rating(4.7).bestTime("Oct-Feb").language("Kannada")
                .imageUrl("https://images.unsplash.com/photo-1590050752117-238cb0fb12b1?w=800").build());
        placeRepository.save(Place.builder().name("Virupaksha Temple")
                .description("Ancient functioning temple at the heart of Hampi ruins — over 700 years old")
                .category("Temple").rating(4.8).timings("6AM-6PM").entryFee("₹25")
                .imageUrl("https://images.unsplash.com/photo-1764426382316-14d5c2fd25b7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fHZpcnVwYWtzaGElMjB0ZW1wbGV8ZW58MHx8MHx8fDA%3D").city(hampi).build());
        hotelRepository.save(Hotel.builder().name("Evolve Back Hampi").type("5 Star").nearPlace("Virupaksha Temple")
                .rating(4.7).pricePerNight(18000).amenities("WiFi,Pool,Spa,Restaurant,Heritage")
                .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(hampi).build());
        foodRepository.save(Food.builder().name("Thali Meals").price(150).isVeg(true).rating(4.5)
                .description("South Indian unlimited thali with rice, sambar, rasam, papad, and local curries")
                .category("Main Course").restaurant("Mango Tree Restaurant").priceRange("₹100-200").mustTry(true)
                .imageUrl("https://media.istockphoto.com/id/473582820/photo/nepali-thali-meal-set-with-mutton-curry.webp?a=1&b=1&s=612x612&w=0&k=20&c=hEym_euZ6oS8CU7D9fiomM9KmiZIJWvBLErYiRZRpAc=").city(hampi).build());

        // --- Coorg ---
        City coorg = cityRepository.save(City.builder().name("Coorg").state("Karnataka").tagline("Scotland of India")
                .description(
                        "Lush coffee-growing region with misty hills, waterfalls, and spice plantations in the Western Ghats.")
                .category("Nature").rating(4.6).bestTime("Oct-Mar").language("Kodava, Kannada")
                .imageUrl("https://images.unsplash.com/photo-1596402184320-417e7178b2cd?w=800").build());
        placeRepository.save(Place.builder().name("Abbey Falls")
                .description("Beautiful 21m waterfall surrounded by coffee and spice plantations").category("Nature")
                .rating(4.4).timings("9AM-5PM").entryFee("₹15")
                .imageUrl("https://images.unsplash.com/flagged/photo-1592544858330-7ac10a0468e5?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8YWJiZXklMjBmYWxsc3xlbnwwfHwwfHx8MA%3D%3D").city(coorg).build());
        hotelRepository.save(Hotel.builder().name("Tamara Coorg").type("5 Star").nearPlace("Abbey Falls").rating(4.7)
                .pricePerNight(16000).amenities("WiFi,Pool,Spa,Restaurant,Mountain View")
                .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(coorg).build());
        foodRepository.save(Food.builder().name("Pandi Curry").price(300).isVeg(false).rating(4.6)
                .description("Coorg's signature pork curry cooked with local Kachampuli vinegar — rich and tangy")
                .category("Main Course").restaurant("Coorg Cuisine").priceRange("₹200-400").mustTry(true)
                .imageUrl("https://plus.unsplash.com/premium_photo-1723708871094-2c02cf5f5394?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8cGFuZGklMjBjdXJyeXxlbnwwfHwwfHx8MA%3D%3D").city(coorg).build());

        // --- Andaman ---
        City andaman = cityRepository.save(City.builder().name("Andaman").state("Andaman & Nicobar")
                .tagline("Tropical Paradise")
                .description(
                        "Crystal-clear waters, white sandy beaches, vibrant coral reefs, and the historic Cellular Jail.")
                .category("Beach").rating(4.7).bestTime("Nov-May").language("Hindi, Bengali, Tamil")
                .imageUrl("https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=800").build());
        placeRepository.save(Place.builder().name("Radhanagar Beach")
                .description("Asia's #1 beach — pristine white sand with turquoise waters on Havelock Island")
                .category("Beach").rating(4.9).timings("24 Hours").entryFee("Free")
                .imageUrl("https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=400").city(andaman).build());
        hotelRepository.save(Hotel.builder().name("Taj Exotica Resort").type("5 Star").nearPlace("Radhanagar Beach")
                .rating(4.7).pricePerNight(20000).amenities("WiFi,Pool,Spa,Beach Access,Restaurant")
                .imageUrl("https://images.unsplash.com/photo-1566073771259-6a8506099945?w=400").city(andaman).build());
        foodRepository.save(Food.builder().name("Fish Tikka").price(300).isVeg(false).rating(4.5)
                .description("Fresh catch of the day marinated in spices and grilled — island-fresh seafood")
                .category("Main Course").restaurant("Anju Coco Restaurant").priceRange("₹200-400").mustTry(true)
                .imageUrl("https://www.shutterstock.com/image-photo/fish-tikka-260nw-273799436.jpg").city(andaman).build());

        log.info("Seeded 25 cities with places, hotels, and foods");
    }

    private void seedTransport() {
        transportRepository.saveAll(List.of(
                // Delhi → Jaipur
                Transport.builder().type(Transport.TransportType.BUS).operator("Rajasthan State Transport")
                        .fromCity("Delhi").toCity("Jaipur").departure("06:00 AM").arrival("12:30 PM").duration("6h 30m")
                        .price(650).availableSeats(23).rating(4.2).travelClass("AC Sleeper").build(),
                Transport.builder().type(Transport.TransportType.BUS).operator("IntrCity SmartBus").fromCity("Delhi")
                        .toCity("Jaipur").departure("11:30 PM").arrival("05:00 AM").duration("5h 30m").price(999)
                        .availableSeats(8).rating(4.8).travelClass("Premium AC").build(),
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Shatabdi Express").fromCity("Delhi")
                        .toCity("Jaipur").departure("06:05 AM").arrival("10:40 AM").duration("4h 35m").price(785)
                        .availableSeats(45).rating(4.6).travelClass("Chair Car").build(),
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Ajmer Shatabdi").fromCity("Delhi")
                        .toCity("Jaipur").departure("02:50 PM").arrival("07:45 PM").duration("4h 55m").price(690)
                        .availableSeats(32).rating(4.3).travelClass("AC 2 Tier").build(),
                Transport.builder().type(Transport.TransportType.FLIGHT).operator("IndiGo").fromCity("Delhi")
                        .toCity("Jaipur").departure("07:15 AM").arrival("08:25 AM").duration("1h 10m").price(3200)
                        .availableSeats(15).rating(4.4).travelClass("Economy").build(),
                // Delhi → Goa
                Transport.builder().type(Transport.TransportType.FLIGHT).operator("IndiGo").fromCity("Delhi")
                        .toCity("Goa").departure("06:30 AM").arrival("09:00 AM").duration("2h 30m").price(4500)
                        .availableSeats(20).rating(4.4).travelClass("Economy").build(),
                Transport.builder().type(Transport.TransportType.FLIGHT).operator("Air India").fromCity("Delhi")
                        .toCity("Goa").departure("01:00 PM").arrival("03:40 PM").duration("2h 40m").price(5800)
                        .availableSeats(10).rating(4.2).travelClass("Economy").build(),
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Goa Express").fromCity("Delhi")
                        .toCity("Goa").departure("03:00 PM").arrival("07:00 AM+1").duration("16h").price(1200)
                        .availableSeats(60).rating(4.0).travelClass("AC 3 Tier").build(),
                // Delhi → Manali
                Transport.builder().type(Transport.TransportType.BUS).operator("HRTC Volvo").fromCity("Delhi")
                        .toCity("Manali").departure("05:00 PM").arrival("07:00 AM").duration("14h").price(1200)
                        .availableSeats(30).rating(4.3).travelClass("Volvo AC").build(),
                Transport.builder().type(Transport.TransportType.BUS).operator("HPTDC Deluxe").fromCity("Delhi")
                        .toCity("Manali").departure("06:30 PM").arrival("08:30 AM").duration("14h").price(1500)
                        .availableSeats(15).rating(4.5).travelClass("Semi-Sleeper").build(),
                // Delhi → Agra
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Gatimaan Express").fromCity("Delhi")
                        .toCity("Agra").departure("08:10 AM").arrival("09:50 AM").duration("1h 40m").price(990)
                        .availableSeats(50).rating(4.8).travelClass("Executive Chair Car").build(),
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Shatabdi Express").fromCity("Delhi")
                        .toCity("Agra").departure("06:00 AM").arrival("08:00 AM").duration("2h").price(755)
                        .availableSeats(40).rating(4.6).travelClass("Chair Car").build(),
                Transport.builder().type(Transport.TransportType.BUS).operator("UPSRTC AC").fromCity("Delhi")
                        .toCity("Agra").departure("06:30 AM").arrival("10:30 AM").duration("4h").price(450)
                        .availableSeats(35).rating(3.9).travelClass("AC Seater").build(),
                // Delhi → Rishikesh
                Transport.builder().type(Transport.TransportType.BUS).operator("UPSRTC Volvo").fromCity("Delhi")
                        .toCity("Rishikesh").departure("10:00 PM").arrival("04:30 AM").duration("6h 30m").price(800)
                        .availableSeats(25).rating(4.2).travelClass("Volvo AC").build(),
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Dehradun Shatabdi").fromCity("Delhi")
                        .toCity("Rishikesh").departure("06:45 AM").arrival("12:30 PM").duration("5h 45m").price(680)
                        .availableSeats(55).rating(4.4).travelClass("Chair Car").build(),
                // Delhi → Varanasi
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Vande Bharat Express")
                        .fromCity("Delhi").toCity("Varanasi").departure("06:00 AM").arrival("02:00 PM").duration("8h")
                        .price(1850).availableSeats(30).rating(4.7).travelClass("Chair Car AC").build(),
                Transport.builder().type(Transport.TransportType.FLIGHT).operator("IndiGo").fromCity("Delhi")
                        .toCity("Varanasi").departure("07:00 AM").arrival("08:30 AM").duration("1h 30m").price(3800)
                        .availableSeats(18).rating(4.4).travelClass("Economy").build(),
                // Delhi → Mumbai
                Transport.builder().type(Transport.TransportType.FLIGHT).operator("IndiGo").fromCity("Delhi")
                        .toCity("Mumbai").departure("06:00 AM").arrival("08:10 AM").duration("2h 10m").price(3500)
                        .availableSeats(35).rating(4.4).travelClass("Economy").build(),
                Transport.builder().type(Transport.TransportType.FLIGHT).operator("Vistara").fromCity("Delhi")
                        .toCity("Mumbai").departure("09:00 AM").arrival("11:15 AM").duration("2h 15m").price(5500)
                        .availableSeats(12).rating(4.7).travelClass("Premium Economy").build(),
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Rajdhani Express").fromCity("Delhi")
                        .toCity("Mumbai").departure("04:00 PM").arrival("08:30 AM+1").duration("16h 30m").price(2100)
                        .availableSeats(45).rating(4.5).travelClass("AC 2 Tier").build(),
                // Delhi → Udaipur
                Transport.builder().type(Transport.TransportType.FLIGHT).operator("IndiGo").fromCity("Delhi")
                        .toCity("Udaipur").departure("08:00 AM").arrival("09:20 AM").duration("1h 20m").price(3900)
                        .availableSeats(20).rating(4.4).travelClass("Economy").build(),
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Chetak Express").fromCity("Delhi")
                        .toCity("Udaipur").departure("07:00 PM").arrival("07:30 AM+1").duration("12h 30m").price(950)
                        .availableSeats(40).rating(4.1).travelClass("AC 3 Tier").build(),
                // Delhi → Kerala
                Transport.builder().type(Transport.TransportType.FLIGHT).operator("Air India").fromCity("Delhi")
                        .toCity("Kerala").departure("06:15 AM").arrival("09:30 AM").duration("3h 15m").price(5200)
                        .availableSeats(15).rating(4.3).travelClass("Economy").build(),
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Kerala Express").fromCity("Delhi")
                        .toCity("Kerala").departure("11:15 AM").arrival("06:45 PM+1").duration("31h 30m").price(1800)
                        .availableSeats(60).rating(4.0).travelClass("AC 3 Tier").build(),
                // Mumbai → Goa
                Transport.builder().type(Transport.TransportType.FLIGHT).operator("IndiGo").fromCity("Mumbai")
                        .toCity("Goa").departure("08:00 AM").arrival("09:10 AM").duration("1h 10m").price(2800)
                        .availableSeats(25).rating(4.4).travelClass("Economy").build(),
                Transport.builder().type(Transport.TransportType.TRAIN).operator("Jan Shatabdi").fromCity("Mumbai")
                        .toCity("Goa").departure("05:10 AM").arrival("04:20 PM").duration("11h 10m").price(600)
                        .availableSeats(80).rating(4.1).travelClass("AC Chair Car").build(),
                Transport.builder().type(Transport.TransportType.BUS).operator("Paulo Travels").fromCity("Mumbai")
                        .toCity("Goa").departure("07:00 PM").arrival("07:00 AM").duration("12h").price(900)
                        .availableSeats(18).rating(4.3).travelClass("AC Sleeper").build()));
        log.info("Seeded transport data for major routes");
    }
}
