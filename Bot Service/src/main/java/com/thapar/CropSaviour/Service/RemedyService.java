package com.thapar.CropSaviour.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.IOException;

@Service
public class RemedyService {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    TranslateService translateService;


    public SendMessage getRemedy(String cropType, String disease, Long chatId) {
        String language = userInfoService.getLanguageByChatId(chatId);
        if (cropType.equalsIgnoreCase("rice")) {
            if (language.equalsIgnoreCase("english")) {
                return riceDiseaseEnglish(disease, chatId);
            } else if (language.equalsIgnoreCase("hindi")) {
                return riceDiseaseHindi(disease, chatId);
            }
            return riceDiseasePunjabi(disease, chatId);
        } else {
            if (language.equalsIgnoreCase("english")) {
                return wheatDiseaseEnglish(disease, chatId);
            } else if (language.equalsIgnoreCase("hindi")) {
                return wheatDiseaseHindi(disease, chatId);
            }
            return wheatDiseasePunjabi(disease, chatId);
        }
    }

    private SendMessage riceDiseaseEnglish(String disease, Long chatId) {
        SendMessage remedy = new SendMessage();
        if (disease.equalsIgnoreCase("Bacterial Blight")) {
            remedy.setText("""
                    BACTERIAL BLIGHT REMEDIES

                    Preventive method
                    1.Seed treatment with bleaching powder (100g/l) and zinc sulfate (2%) reduce bacterial blight.
                    2.Seed treatment - seed soaking for 8 hours in Agrimycin (0.025%) and wettable ceresan (0.05%) followed by hot water treatment for 30 min at 52-54oC;
                    3.seed soaking for 8 hours in ceresan (0.1%) and treat with Streptocyclin (3g in 1 litre);
                    4.Spray neem oil 3% or NSKE 5%
                    5.Spray fresh cowdung extract for the control of bacterial blight. Dissolve 20 g cowdung in one litre of water; allow to settle and sieve. Use supernatant liquid. (starting from initial appearance of the disease and another at fortnightly interval)
                    Cultural methods
                    1.Grow nurseries preferably in isolated upland conditions
                    2.Avoid clipping of seedlings during transplanting.
                    3.Drain the field (except at flowering stage of the crop)
                    4.Destruction of weeds and  collateral hosts
                    5.Avoid flow of water from affected fields
                    6.Maintain proper plant spacing


                    FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx

                    OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551) """);

        } else if (disease.equalsIgnoreCase("Blast") || disease.equalsIgnoreCase("Leaf Blast")) {
            remedy.setText("""
                    BLAST REMEDIES
                    Preventive Measures 
                    1. Use healthy or certified seed material.
                    2. Plant resistant varieties available in the area.
                    3. Sow seeds early in the season, after the onset of the rainy season. 
                    4. Avoid excessive nitrogen fertilization and split the applications into two 
                    or more treatments. 
                    5. Avoid drought stress to the plants with regular irrigation. 
                    6. Keep a proper flood level for the rice to grow properly. 
                    7. Maintain continuous flooding and avoid drainage of the rice field. 
                    8. Maintain control of weeds and alternative hosts. 
                    9. Apply silicon fertilizers if the soil is known to be silicon deficient. 
                    10. Cheap sources of silicon include straws of rice varieties with the high 
                    silicon content. 
                    11. Monitor your field regularly for symptoms. 
                    12. Destroy all infected plant residues to prevent the carry-over of the fungus 
                    in the field. 
                    13. Plan a crop rotation as a simple and effective way to reduce populations.


                    FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx

                    OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Brownspot")) {
            remedy.setText("""
                    BROWN SPOT REMEDIES

                    Cultural methods
                    1.As disease is seed borne,Use disease free seeds.
                    2.Removal of alternate & collateral hosts.
                    3.The use of resistant varieties is the most economical means of control.
                    4.Growing Resistant varieties like ADT 44,PY 4,CORH 1,CO 44,CAUVERY,BHAVANI,TPS 4 and Dhanu.
                    5.Providing proper nutrition for optimum plant growth and prevention of water stress seem to be the most important factors in controlling brown spot.

                    Preventive methods
                    1.Seed treatment with Pseudomonas fluorescens @ 10g/kg of seed followed by seedling dip @ of 2.5 kg or products/ha dissolved in 100 litres and dipping for 30 minutes.
                    2.seed soak / seed treatment with Captan or  Thiram at 2.0g /kg of seed
                    3.Since the fungus is seed transmitted, a hot water seed treatment (53-54°C) for 10-12 minutes may be effective before sowing. This treatment controls primary infection at the seedling stage. Presoaking the seed in cold water for 8 hours increases effectivity of the treatment.


                    FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx

                    OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Hispa")) {
            remedy.setText("""
                    1.Avoid over fertilizing the field.
                    2.Close plant spacing results in greater leaf densities that can tolerate higher hispa numbers.
                    3.Leaf tip containing blotch mines should be destroyed.
                    4.Manual collection and killing of beetles – hand nets.
                    5.To prevent egg laying of the pests, the shoot tips can be cut.
                    6.Clipping and burying shoots in the mud can reduce grub populations by 75 - 92%.
                    7.Reduviid bug eats upon the adults.
                    8.Spraying of methyl parathion 0.05% or Quinalphos 0.05%.
                                       
                    Cultural methods
                    1. Planting of resistant varieties against tungro virus disease is the most economical means of managing the disease.
                    2. Use  Resistant varieties like IR 36,  IR 50 ,ADT 37,  Ponmani, Co 45, Co 48, Surekha, Vikramarya, Bharani, IR 36   and white ponni .
                    3. Among the cultural management practices, adjusting the date of planting is recommended.
                    4.  Likewise, observing a fallow period of at least a month to eliminate hosts and viruses and vectors of the disease.
                    5.  In epidemic areas follow rotation with pulses or oil seeds.
                    6. Apply neem cake @ 12.5 kg/20 cent nursery as basal dose.
                    7.  plouging and harrowing the field to destroy stubbles right after harvest in order to eradicate other tungro hosts are also advisable.
                    8. Destruction of weed hosts on bunds.

                    Chemical methods
                    •  Leaf yellowing can be minimized by spraying 2 % urea mixed with Mancozeb at 2.5 gm/lit.
                    • Instead of urea foliar fertilizer like multi-K (potassium nitrate) can be sprayed at 1 per cent which impart resistance also because of high potassium content.
                    • Green leaf hoppers as vectors are to be controlled effectively in time by spraying.
                    • Spray insecticides twice, 15 and 30 days after transplanting

                    Spray Two rounds of any one of the following insecticides
                    ◦ Monocrotophos 36 WSC (40 ml/ha)
                    ◦ Fenthion 100 EC (40 ml/ha) may be sprayed 15 and 30 days after transplanting.


                    FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx

                    OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Tungro")) {
            remedy.setText("""
                    Trap methods:
                    Light traps are to be set up to attract and control the leaf hopper vectors as well as to monitor the population.
                    In the early morning, the population of leafhopper alighting near the light trap should be killed by spraying/dusting the insecticides. This should be practiced every day.
                                        
                    Cultural methods:
                    Planting of resistant varieties against tungro virus disease is the most economical means of managing the disease.
                    Use  resistant varieties like IR 36,  IR 50, ADT 37,  Ponmani, Co 45, Co 48, Surekha, Vikramarya, Bharani, IR 36 and white ponni .
                    Among the cultural management practices, adjusting the date of planting is recommended.
                     Likewise, observing a fallow period of at least a month to eliminate hosts and viruses and vectors of the disease.
                     In epidemic areas follow rotation with pulses or oil seeds.
                    Apply neem cake @ 12.5 kg/20 cent nursery as basal dose.
                    Plouging and harrowing the field to destroy stubbles right after harvest
                    Eradicate of other tungro hosts are also advisable.
                    Destruction of weed hosts on bunds.
                                        
                    Chemical methods:
                    Leaf yellowing can be minimized by spraying 2 % urea mixed with Mancozeb at 2.5 gm/lit.
                    Instead of urea foliar fertilizer like multi-K (potassium nitrate) can be sprayed at 1 per cent which impart disease resistance because of high potassium content.
                    Green leaf hoppers as vectors are to be controlled effectively in time by spraying.
                    Vegetation on the bunds should also be sprayed with the insecticides. Maintain 2.5 cm of water in the nursery and broadcast anyone of the following in 20 cents Carbofuran 3 G 3.5 kg (or) Phorate 10 G 1.0 kg (or) Quinalphos 5 G 2.0 kg.
                    In nursery when virus infection is low, apply Carbofuran granules @ 1 kg/ha to control vector population.
                    During pre-tillering to mid-tillering when one affected hill/m is observed start application of Carbofuran granules @ 3.5kg/ha to control insect vector.
                    Spray Two rounds of any one of the following insecticides
                    Thiamethoxam 25 WDG 100g/ha (or)
                    Imidacloprid 17.8 SL 100ml/ha at 15 and 30 days after transplanting. The vegetation on the bunds should also be sprayed with the insecticides.  

                    FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx


                    OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551) """);
        } else {
            remedy.setText("You have healthy crop");
        }
        remedy.setChatId(chatId);
        return remedy;
    }

    private SendMessage riceDiseaseHindi(String disease, Long chatId) {
        SendMessage remedy = new SendMessage();
        if (disease.equalsIgnoreCase("Bacterial Blight")) {
            remedy.setText("""
                    बैक्टीरियल ब्लाइट उपचार

                    निवारक विधि
                    1. ब्लीचिंग पाउडर (100 ग्राम/ली) और जिंक सल्फेट (2%) से बीज उपचार करने से जीवाणु झुलसा कम हो जाता है।
                    2.बीज उपचार - एग्रीमाइसिन (0.025%) और वेटेबल सेरेसन (0.05%) में 8 घंटे के लिए बीज भिगोने के बाद 52-54oC पर 30 मिनट के लिए गर्म पानी का उपचार;
                    3. बीज को सेरेसन (0.1%) में 8 घंटे तक भिगोकर रखें और स्ट्रेप्टोसाइक्लिन (3 ग्राम प्रति 1 लीटर) से उपचारित करें;
                    4. नीम का तेल 3% या एनएसकेई 5% स्प्रे करें
                    5. बैक्टीरियल ब्लाइट के नियंत्रण के लिए ताजा गोबर के अर्क का छिड़काव करें। एक लीटर पानी में 20 ग्राम गोबर घोलें; बसने और छानने की अनुमति दें। सतह पर तैरनेवाला तरल का प्रयोग करें। (रोग के प्रारंभिक रूप से शुरू होकर और दूसरा पाक्षिक अंतराल पर)
                    सांस्कृतिक तरीके
                    1. नर्सरी को अलग-अलग ऊपरी इलाकों में अधिमानतः विकसित करें
                    2. रोपाई के दौरान रोपाई की कतरन से बचें।
                    3. खेत को सूखा दें (फसल के फूल आने की अवस्था को छोड़कर)
                    4. मातम और संपार्श्विक मेजबानों का विनाश
                    5. प्रभावित क्षेत्रों से पानी के बहाव से बचें
                    6. पौधों के बीच उचित दूरी बनाए रखें


                    अधिक जानकारी के लिए देखें https://farmer.gov.in/FarmerHome.aspx

                    या किसान कॉल सेंटर (केसीसी) से संपर्क करें (टोल फ्री नंबर 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Blast") || disease.equalsIgnoreCase("Leaf Blast")) {
            remedy.setText("""
                    विस्फोट के उपाय
                    निवारक उपाय
                    1. स्वस्थ या प्रमाणित बीज सामग्री का प्रयोग करें।
                    2. क्षेत्र में उपलब्ध पौधे प्रतिरोधी किस्में।
                    3. वर्षा ऋतु की शुरुआत के बाद, मौसम में जल्दी बीज बोएं।
                    4. अत्यधिक नाइट्रोजन उर्वरक से बचें और अनुप्रयोगों को दो में विभाजित करें
                    या अधिक उपचार।
                    5. नियमित सिंचाई से पौधों को सूखे के दबाव से बचाएं।
                    6. चावल के ठीक से बढ़ने के लिए उचित बाढ़ स्तर रखें।
                    7. निरंतर बाढ़ बनाए रखें और चावल के खेत की जल निकासी से बचें।
                    8. खर-पतवार और वैकल्पिक मेजबानों का नियंत्रण बनाए रखें।
                    9. यदि मिट्टी में सिलिकॉन की कमी हो तो सिलिकॉन उर्वरकों का प्रयोग करें।
                    10. सिलिकॉन के सस्ते स्रोतों में चावल की किस्मों के स्ट्रॉ शामिल हैं जिनमें उच्च
                    सिलिकॉन सामग्री।
                    11. लक्षणों के लिए नियमित रूप से अपने क्षेत्र की निगरानी करें।
                    12. कवक को फैलने से रोकने के लिए सभी संक्रमित पौधों के अवशेषों को नष्ट कर दें
                    क्षेत्र में।
                    13. आबादी को कम करने के लिए एक सरल और प्रभावी तरीके के रूप में फसल चक्र की योजना बनाएं।


                    अधिक जानकारी के लिए देखें https://farmer.gov.in/FarmerHome.aspx

                    या किसान कॉल सेंटर (केसीसी) से संपर्क करें (टोल फ्री नंबर 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Brownspot")) {
            remedy.setText("""
                    ब्राउन स्पॉट उपचार

                    सांस्कृतिक तरीके
                    1. क्योंकि रोग बीज जनित है, रोगमुक्त बीजों का प्रयोग करें।
                    2. वैकल्पिक और संपार्श्विक मेजबानों को हटाना।
                    3. प्रतिरोधी किस्मों का उपयोग नियंत्रण का सबसे किफायती साधन है।
                    4. एडीटी 44, पीवाई 4, कोरह 1, सीओ 44, कावेरी, भवानी, टीपीएस 4 और धनु जैसी प्रतिरोधी किस्मों को उगाना।
                    5. इष्टतम पौधों की वृद्धि के लिए उचित पोषण प्रदान करना और पानी के तनाव की रोकथाम ब्राउन स्पॉट को नियंत्रित करने में सबसे महत्वपूर्ण कारक प्रतीत होते हैं।

                    निवारक तरीके
                    1. स्यूडोमोनास फ्लोरेसेंस @ 10 ग्राम/किलोग्राम बीज के साथ बीज उपचार के बाद 2.5 किग्रा की दर से अंकुर डुबकी या 100 लीटर में उत्पाद/हेक्टेयर घोलकर 30 मिनट के लिए डुबोएं।
                    2. बीज सोख/बीज उपचार कैप्टन या थिरम के साथ 2.0 ग्राम/किलोग्राम बीज
                    3.चूंकि कवक बीज संचरित होता है, बुवाई से पहले 10-12 मिनट के लिए गर्म पानी के बीज उपचार (53-54 डिग्री सेल्सियस) प्रभावी हो सकता है। यह उपचार अंकुर अवस्था में प्राथमिक संक्रमण को नियंत्रित करता है। बीज को ठंडे पानी में 8 घंटे तक भिगोने से उपचार की प्रभावशीलता बढ़ जाती है।


                    अधिक जानकारी के लिए देखें https://farmer.gov.in/FarmerHome.aspx

                    या किसान कॉल सेंटर (केसीसी) से संपर्क करें (टोल फ्री नंबर 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Hispa")) {
            remedy.setText("""
                    1. खेत में ज्यादा खाद डालने से बचें।
                    2. पौधे के बीच की दूरी के परिणामस्वरूप अधिक पत्ती घनत्व होता है जो उच्च हिस्पा संख्या को सहन कर सकता है।
                    3. ब्लॉच खानों वाली पत्ती की नोक को नष्ट कर देना चाहिए।
                    4. मैनुअल संग्रह और भृंगों की हत्या - हाथ जाल।
                    5. कीटों के अंडे देने से रोकने के लिए, अंकुरों की युक्तियों को काटा जा सकता है।
                    6. प्ररोहों को मिट्टी में काटने और दफनाने से ग्रब की आबादी 75-92% तक कम हो सकती है।
                    7.Reduviid बग वयस्कों को खाता है।
                    8. मिथाइल पैराथियान 0.05% या क्विनालफॉस 0.05% का छिड़काव।
                                       
                    सांस्कृतिक तरीके
                    1. टुंग्रो वायरस रोग के खिलाफ प्रतिरोधी किस्मों का रोपण रोग के प्रबंधन का सबसे किफायती साधन है।
                    2. आईआर 36, आईआर 50, एडीटी 37, पोनमनी, सीओ 45, सीओ 48, सुरेखा, विक्रमारी, भरणी, आईआर 36 और सफेद पोनी जैसी प्रतिरोधी किस्मों का प्रयोग करें।
                    3. सांस्कृतिक प्रबंधन प्रथाओं के बीच, रोपण की तारीख को समायोजित करने की सिफारिश की जाती है।
                    4. इसी तरह, रोग के मेजबान और वायरस और वैक्टर को खत्म करने के लिए कम से कम एक महीने की परती अवधि का पालन करना।
                    5. महामारी वाले क्षेत्रों में दलहन या तिलहन के साथ रोटेशन का पालन करें।
                    6. नीम केक @ 12.5 किग्रा/20 प्रतिशत नर्सरी बेसल खुराक के रूप में लगाएं।
                    7. फसल के तुरंत बाद ठूंठों को नष्ट करने के लिए खेत की जुताई और जुताई करने की भी सलाह दी जाती है ताकि अन्य टंग्रो मेजबानों को नष्ट किया जा सके।
                    8. मेड़ों पर खरपतवार नाशकों का विनाश।
                                        
                    रासायनिक तरीके
                    •  मैंकोजेब में 2.5 ग्राम/लीटर यूरिया मिलाकर 2% यूरिया का छिड़काव करके पत्तियों के पीलेपन को कम किया जा सकता है।
                    • यूरिया के बजाय मल्टी-के (पोटेशियम नाइट्रेट) जैसे पत्तेदार उर्वरक का 1 प्रतिशत छिड़काव किया जा सकता है जो उच्च पोटेशियम सामग्री के कारण प्रतिरोध भी प्रदान करता है।
                    • रोगवाहक के रूप में हरी पत्ती हॉपर को समय पर छिड़काव द्वारा प्रभावी ढंग से नियंत्रित किया जाना है।
                    • रोपाई के 15 और 30 दिन बाद दो बार कीटनाशकों का छिड़काव करें

                    निम्नलिखित कीटनाशकों में से किसी एक का दो बार छिड़काव करें
                    मोनोक्रोटोफॉस 36 डब्ल्यूएससी (40 मिली/हे.)
                    फेन्थियन 100 ईसी (40 मिली/हेक्टेयर) का छिड़काव रोपाई के 15 और 30 दिन बाद किया जा सकता है।


                    अधिक जानकारी के लिए देखें https://farmer.gov.in/FarmerHome.aspx

                    या किसान कॉल सेंटर (केसीसी) से संपर्क करें (टोल फ्री नंबर 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Tungro")) {
            remedy.setText("""
                    जाल विधियाँ:

                    लीफ हॉपर वैक्टर को आकर्षित करने और नियंत्रित करने के साथ-साथ आबादी की निगरानी के लिए लाइट ट्रैप स्थापित किए जाने हैं।
                    प्रात:काल प्रकाश ट्रैप के पास उतरते हुए लीफहॉपर की आबादी को कीटनाशकों के छिड़काव/धूल से मार देना चाहिए। इसका अभ्यास प्रतिदिन करना चाहिए।
                    सांस्कृतिक तरीके:

                    टुंग्रो वायरस रोग के खिलाफ प्रतिरोधी किस्मों का रोपण रोग के प्रबंधन का सबसे किफायती साधन है।
                    प्रतिरोधी किस्मों जैसे IR 36, IR 50, ADT 37, Ponmani, Co 45, Co 48, सुरेखा, विक्रमरी, भरणी, IR 36 और सफेद पोनी का प्रयोग करें।
                    सांस्कृतिक प्रबंधन प्रथाओं के बीच, रोपण की तारीख को समायोजित करने की सिफारिश की जाती है।
                     इसी तरह, रोग के मेजबान और वायरस और वैक्टर को खत्म करने के लिए कम से कम एक महीने की परती अवधि का पालन करना।
                     महामारी क्षेत्रों में दलहन या तिलहन के साथ रोटेशन का पालन करें।
                    नीम केक @ 12.5 किग्रा/20 प्रतिशत नर्सरी बेसल खुराक के रूप में डालें।
                    फसल के तुरंत बाद ठूंठों को नष्ट करने के लिए खेत की जुताई और जुताई
                    अन्य टुंग्रो मेजबानों का उन्मूलन भी उचित है।
                    मेड़ों पर खरपतवार नाशकों का विनाश।
                    रासायनिक तरीके:
                    2.5 ग्राम प्रति लीटर की दर से मैनकोजेब के साथ मिश्रित 2% यूरिया का छिड़काव करके पत्ती के पीलेपन को कम किया जा सकता है।
                    यूरिया के बजाय मल्टी-के (पोटेशियम नाइट्रेट) जैसे पत्तेदार उर्वरक का 1 प्रतिशत छिड़काव किया जा सकता है जो उच्च पोटेशियम सामग्री के कारण रोग प्रतिरोधक क्षमता प्रदान करता है।
                    रोगवाहक के रूप में हरी पत्ती हॉपर को समय पर छिड़काव द्वारा प्रभावी ढंग से नियंत्रित किया जाना है।
                    मेड़ों पर सब्जियों का भी कीटनाशकों का छिड़काव करना चाहिए। नर्सरी में 2.5 सेमी पानी बनाए रखें और निम्नलिखित में से किसी को भी 20 सेंट कार्बोफुरन 3 जी 3.5 किग्रा (या) फोरेट 10 जी 1.0 किग्रा (या) क्विनालफॉस 5 जी 2.0 किग्रा में प्रसारित करें।
                    नर्सरी में जब वायरस का संक्रमण कम हो, तो वेक्टर आबादी को नियंत्रित करने के लिए कार्बोफ्यूरन ग्रेन्यूल्स @ 1 किग्रा/हेक्टेयर लगाएं।
                    जुताई से पहले से मध्य जुताई के दौरान जब एक प्रभावित पहाड़ी/मीटर देखा जाता है तो कीट वेक्टर को नियंत्रित करने के लिए 3.5 किग्रा/हेक्टेयर की दर से कार्बोफुरन दानों का प्रयोग शुरू करें।
                    निम्नलिखित कीटनाशकों में से किसी एक का दो बार छिड़काव करें
                    थियामेथोक्सम 25 डब्ल्यूडीजी 100 ग्राम/हेक्टेयर (या)
                    रोपाई के 15 और 30 दिन बाद इमिडाक्लोप्रिड 17.8 एसएल 100 मि.ली./हेक्टेयर। मेड़ों की वनस्पति पर भी कीटनाशकों का छिड़काव करना चाहिए।
                                
                    अधिक जानकारी के लिए देखें https://farmer.gov.in/FarmerHome.aspx
                                
                                
                    या किसान कॉल सेंटर (केसीसी) से संपर्क करें (टोल फ्री नंबर 1800-180-1551) """);
        } else {
            remedy.setText("आपके पास स्वस्थ फसल है");
        }
        remedy.setChatId(chatId);
        return remedy;
    }

    private SendMessage riceDiseasePunjabi(String disease, Long chatId) {
        SendMessage remedy = new SendMessage();
        if (disease.equalsIgnoreCase("Bacterial Blight")) {
            remedy.setText("""
                    ਬੈਕਟੀਰੀਅਲ ਬਲਾਈਟ ਉਪਚਾਰ

                    ਰੋਕਥਾਮ ਵਿਧੀ
                    1. ਬਲੀਚਿੰਗ ਪਾਊਡਰ (100 ਗ੍ਰਾਮ/ਲੀ) ਅਤੇ ਜ਼ਿੰਕ ਸਲਫੇਟ (2%) ਨਾਲ ਬੀਜ ਦਾ ਇਲਾਜ ਬੈਕਟੀਰੀਆ ਦੇ ਝੁਲਸ ਨੂੰ ਘਟਾਉਂਦਾ ਹੈ।
                    2. ਬੀਜ ਦਾ ਇਲਾਜ - ਬੀਜ ਨੂੰ 8 ਘੰਟਿਆਂ ਲਈ ਐਗਰੀਮਾਈਸਿਨ (0.025%) ਅਤੇ ਗਿੱਲੇ ਹੋਣ ਯੋਗ ਸੇਰੇਸਨ (0.05%) ਵਿੱਚ ਭਿੱਜਣਾ ਅਤੇ 52-54 ਡਿਗਰੀ ਸੈਲਸੀਅਸ ਤਾਪਮਾਨ 'ਤੇ 30 ਮਿੰਟ ਲਈ ਗਰਮ ਪਾਣੀ ਦੇ ਇਲਾਜ ਦੁਆਰਾ;
                    3. ਬੀਜ ਨੂੰ ਸੇਰੇਸਨ (0.1%) ਵਿੱਚ 8 ਘੰਟਿਆਂ ਲਈ ਭਿਉਂ ਕੇ ਰੱਖੋ ਅਤੇ ਸਟ੍ਰੈਪਟੋਸਾਈਕਲਿਨ (1 ਲੀਟਰ ਵਿੱਚ 3 ਗ੍ਰਾਮ);
                    4. ਨਿੰਮ ਦਾ ਤੇਲ 3% ਜਾਂ NSKE 5% ਦਾ ਛਿੜਕਾਅ ਕਰੋ।
                    5. ਬੈਕਟੀਰੀਆ ਦੇ ਝੁਲਸ ਦੇ ਨਿਯੰਤਰਣ ਲਈ ਤਾਜ਼ੇ ਗੋਹੇ ਦੇ ਐਬਸਟਰੈਕਟ ਦਾ ਛਿੜਕਾਅ ਕਰੋ। 20 ਗ੍ਰਾਮ ਗੋਬਰ ਨੂੰ ਇੱਕ ਲੀਟਰ ਪਾਣੀ ਵਿੱਚ ਘੋਲੋ; ਸੈਟਲ ਕਰਨ ਅਤੇ ਛਾਲਣ ਦੀ ਆਗਿਆ ਦਿਓ. ਸੁਪਰਨੇਟੈਂਟ ਤਰਲ ਦੀ ਵਰਤੋਂ ਕਰੋ। (ਬਿਮਾਰੀ ਦੀ ਸ਼ੁਰੂਆਤੀ ਦਿੱਖ ਤੋਂ ਸ਼ੁਰੂ ਹੋ ਕੇ ਅਤੇ ਪੰਦਰਵਾੜੇ ਦੇ ਅੰਤਰਾਲ 'ਤੇ ਦੂਜਾ)
                    ਸੱਭਿਆਚਾਰਕ ਢੰਗ
                    1. ਨਰਸਰੀਆਂ ਨੂੰ ਤਰਜੀਹੀ ਤੌਰ 'ਤੇ ਅਲੱਗ-ਥਲੱਗ ਪਹਾੜੀ ਸਥਿਤੀਆਂ ਵਿੱਚ ਵਧਾਓ
                    2. ਟਰਾਂਸਪਲਾਂਟਿੰਗ ਦੌਰਾਨ ਬੂਟਿਆਂ ਨੂੰ ਕੱਟਣ ਤੋਂ ਬਚੋ।
                    3. ਖੇਤ ਦਾ ਨਿਕਾਸ ਕਰੋ (ਫਸਲ ਦੇ ਫੁੱਲਾਂ ਦੇ ਪੜਾਅ ਨੂੰ ਛੱਡ ਕੇ)
                    4. ਜੰਗਲੀ ਬੂਟੀ ਅਤੇ ਜਮਾਂਦਰੂ ਮੇਜ਼ਬਾਨਾਂ ਦਾ ਵਿਨਾਸ਼
                    5. ਪ੍ਰਭਾਵਿਤ ਖੇਤਾਂ ਤੋਂ ਪਾਣੀ ਦੇ ਵਹਾਅ ਤੋਂ ਬਚੋ
                    6. ਪੌਦਿਆਂ ਦੀ ਉਚਿਤ ਵਿੱਥ ਬਣਾਈ ਰੱਖੋ


                    ਵਧੇਰੇ ਜਾਣਕਾਰੀ ਲਈ https://farmer.gov.in/FarmerHome.aspx 'ਤੇ ਜਾਓ

                    ਜਾਂ ਕਿਸਾਨ ਕਾਲ ਸੈਂਟਰ (ਕੇਸੀਸੀ) ਨਾਲ ਸੰਪਰਕ ਕਰੋ (ਟੋਲ ਫ੍ਰੀ ਨੰਬਰ 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Blast") || disease.equalsIgnoreCase("Leaf Blast")) {
            remedy.setText("""
                    Blast ਦੇ ਉਪਾਅ
                    ਰੋਕਥਾਮ ਉਪਾਅ
                    1. ਸਿਹਤਮੰਦ ਜਾਂ ਪ੍ਰਮਾਣਿਤ ਬੀਜ ਸਮੱਗਰੀ ਦੀ ਵਰਤੋਂ ਕਰੋ।
                    2. ਖੇਤਰ ਵਿੱਚ ਉਪਲਬਧ ਰੋਧਕ ਕਿਸਮਾਂ ਬੀਜੋ।
                    3. ਬਰਸਾਤੀ ਮੌਸਮ ਸ਼ੁਰੂ ਹੋਣ ਤੋਂ ਬਾਅਦ ਸੀਜ਼ਨ ਦੇ ਸ਼ੁਰੂ ਵਿੱਚ ਬੀਜ ਬੀਜੋ।
                    4. ਬਹੁਤ ਜ਼ਿਆਦਾ ਨਾਈਟ੍ਰੋਜਨ ਖਾਦ ਪਾਉਣ ਤੋਂ ਬਚੋ ਅਤੇ ਐਪਲੀਕੇਸ਼ਨਾਂ ਨੂੰ ਦੋ ਹਿੱਸਿਆਂ ਵਿੱਚ ਵੰਡੋ
                    ਜਾਂ ਹੋਰ ਇਲਾਜ।
                    5. ਨਿਯਮਤ ਸਿੰਚਾਈ ਨਾਲ ਪੌਦਿਆਂ ਨੂੰ ਸੋਕੇ ਦੇ ਤਣਾਅ ਤੋਂ ਬਚੋ।
                    6. ਚੌਲਾਂ ਨੂੰ ਸਹੀ ਢੰਗ ਨਾਲ ਵਧਣ ਲਈ ਇੱਕ ਸਹੀ ਫਲੱਡ ਪੱਧਰ ਰੱਖੋ।
                    7. ਲਗਾਤਾਰ ਹੜ੍ਹਾਂ ਨੂੰ ਬਣਾਈ ਰੱਖੋ ਅਤੇ ਚੌਲਾਂ ਦੇ ਖੇਤ ਦੇ ਨਿਕਾਸ ਤੋਂ ਬਚੋ।
                    8. ਨਦੀਨਾਂ ਅਤੇ ਵਿਕਲਪਕ ਮੇਜ਼ਬਾਨਾਂ ਦਾ ਨਿਯੰਤਰਣ ਬਣਾਈ ਰੱਖੋ।
                    9. ਜੇਕਰ ਮਿੱਟੀ ਵਿੱਚ ਸਿਲੀਕਾਨ ਦੀ ਘਾਟ ਹੋਣ ਦਾ ਪਤਾ ਲੱਗਦਾ ਹੈ ਤਾਂ ਸਿਲੀਕਾਨ ਖਾਦ ਪਾਓ।
                    10. ਸਿਲੀਕਾਨ ਦੇ ਸਸਤੇ ਸਰੋਤਾਂ ਵਿੱਚ ਉੱਚੇ ਦੇ ਨਾਲ ਚੌਲਾਂ ਦੀਆਂ ਕਿਸਮਾਂ ਦੀਆਂ ਤੂੜੀਆਂ ਸ਼ਾਮਲ ਹਨ
                    ਸਿਲੀਕਾਨ ਸਮੱਗਰੀ.
                    11. ਲੱਛਣਾਂ ਲਈ ਨਿਯਮਿਤ ਤੌਰ 'ਤੇ ਆਪਣੇ ਖੇਤ ਦੀ ਨਿਗਰਾਨੀ ਕਰੋ।
                    12. ਉੱਲੀ ਦੇ ਵਧਣ ਤੋਂ ਰੋਕਣ ਲਈ ਸਾਰੇ ਸੰਕਰਮਿਤ ਪੌਦਿਆਂ ਦੀ ਰਹਿੰਦ-ਖੂੰਹਦ ਨੂੰ ਨਸ਼ਟ ਕਰੋ
                    ਖੇਤਰ ਵਿਚ.
                    13. ਜਨਸੰਖਿਆ ਨੂੰ ਘਟਾਉਣ ਦੇ ਇੱਕ ਸਰਲ ਅਤੇ ਪ੍ਰਭਾਵੀ ਤਰੀਕੇ ਵਜੋਂ ਫਸਲੀ ਚੱਕਰ ਦੀ ਯੋਜਨਾ ਬਣਾਓ।


                    ਵਧੇਰੇ ਜਾਣਕਾਰੀ ਲਈ https://farmer.gov.in/FarmerHome.aspx 'ਤੇ ਜਾਓ

                    ਜਾਂ ਕਿਸਾਨ ਕਾਲ ਸੈਂਟਰ (ਕੇਸੀਸੀ) ਨਾਲ ਸੰਪਰਕ ਕਰੋ (ਟੋਲ ਫ੍ਰੀ ਨੰਬਰ 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Brownspot")) {
            remedy.setText("""
                    ਬਰਾਊਨ ਸਪਾਟ ਦੇ ਉਪਚਾਰ

                    ਸੱਭਿਆਚਾਰਕ ਢੰਗ
                    1. ਕਿਉਂਕਿ ਬਿਮਾਰੀ ਬੀਜ ਪੈਦਾ ਹੁੰਦੀ ਹੈ, ਬਿਮਾਰੀ ਰਹਿਤ ਬੀਜਾਂ ਦੀ ਵਰਤੋਂ ਕਰੋ।
                    2. ਵਿਕਲਪਿਕ ਅਤੇ ਜਮਾਂਦਰੂ ਮੇਜ਼ਬਾਨਾਂ ਨੂੰ ਹਟਾਉਣਾ।
                    3. ਰੋਧਕ ਕਿਸਮਾਂ ਦੀ ਵਰਤੋਂ ਕੰਟਰੋਲ ਦਾ ਸਭ ਤੋਂ ਵੱਧ ਕਿਫ਼ਾਇਤੀ ਸਾਧਨ ਹੈ।
                    4. ADT 44, PY 4, CORH 1, CO 44, ਕਾਵੇਰੀ, ਭਵਾਨੀ, TPS 4 ਅਤੇ ਧਨੂ ਵਰਗੀਆਂ ਵਧਣ ਵਾਲੀਆਂ ਰੋਧਕ ਕਿਸਮਾਂ।
                    5. ਪੌਦਿਆਂ ਦੇ ਸਰਵੋਤਮ ਵਿਕਾਸ ਲਈ ਸਹੀ ਪੋਸ਼ਣ ਪ੍ਰਦਾਨ ਕਰਨਾ ਅਤੇ ਪਾਣੀ ਦੇ ਤਣਾਅ ਦੀ ਰੋਕਥਾਮ ਭੂਰੇ ਧੱਬੇ ਨੂੰ ਕੰਟਰੋਲ ਕਰਨ ਲਈ ਸਭ ਤੋਂ ਮਹੱਤਵਪੂਰਨ ਕਾਰਕ ਜਾਪਦੇ ਹਨ।

                    ਰੋਕਥਾਮ ਦੇ ਤਰੀਕੇ
                    1. ਸੂਡੋਮੋਨਾਸ ਫਲੋਰੋਸੈਨਸ @ 10 ਗ੍ਰਾਮ/ਕਿਲੋ ਬੀਜ ਨਾਲ ਬੀਜ ਦਾ ਇਲਾਜ ਕਰੋ ਅਤੇ ਇਸ ਤੋਂ ਬਾਅਦ 2.5 ਕਿਲੋਗ੍ਰਾਮ @ ਦੀ ਬਿਜਾਈ ਜਾਂ ਉਤਪਾਦ/ਹੈਕਟੇਅਰ 100 ਲੀਟਰ ਵਿੱਚ ਘੋਲ ਕੇ 30 ਮਿੰਟ ਲਈ ਡੁਬੋ ਕੇ ਕਰੋ।
                    2. ਬੀਜ ਨੂੰ 2.0 ਗ੍ਰਾਮ / ਕਿਲੋ ਬੀਜ ਦੇ ਹਿਸਾਬ ਨਾਲ ਕੈਪਟਾਨ ਜਾਂ ਥੀਰਮ ਨਾਲ ਭਿਓ / ਬੀਜ ਦਾ ਇਲਾਜ ਕਰੋ।
                    3.ਕਿਉਂਕਿ ਉੱਲੀ ਦਾ ਬੀਜ ਪ੍ਰਸਾਰਿਤ ਹੁੰਦਾ ਹੈ, ਬਿਜਾਈ ਤੋਂ ਪਹਿਲਾਂ 10-12 ਮਿੰਟਾਂ ਲਈ ਗਰਮ ਪਾਣੀ ਦਾ ਬੀਜ ਇਲਾਜ (53-54°C) ਪ੍ਰਭਾਵਸ਼ਾਲੀ ਹੋ ਸਕਦਾ ਹੈ। ਇਹ ਇਲਾਜ ਬੀਜ ਦੇ ਪੜਾਅ 'ਤੇ ਪ੍ਰਾਇਮਰੀ ਲਾਗ ਨੂੰ ਕੰਟਰੋਲ ਕਰਦਾ ਹੈ। ਬੀਜ ਨੂੰ 8 ਘੰਟਿਆਂ ਲਈ ਠੰਡੇ ਪਾਣੀ ਵਿੱਚ ਭਿਉਂ ਕੇ ਰੱਖਣ ਨਾਲ ਇਲਾਜ ਦੀ ਪ੍ਰਭਾਵਸ਼ੀਲਤਾ ਵਧ ਜਾਂਦੀ ਹੈ।


                    ਵਧੇਰੇ ਜਾਣਕਾਰੀ ਲਈ https://farmer.gov.in/FarmerHome.aspx 'ਤੇ ਜਾਓ

                    ਜਾਂ ਕਿਸਾਨ ਕਾਲ ਸੈਂਟਰ (ਕੇਸੀਸੀ) ਨਾਲ ਸੰਪਰਕ ਕਰੋ (ਟੋਲ ਫ੍ਰੀ ਨੰਬਰ 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Hispa")) {
            remedy.setText("""
                    Hispa ਦੇ ਉਪਚਾਰ:
                    1. ਖੇਤ ਨੂੰ ਜ਼ਿਆਦਾ ਖਾਦ ਪਾਉਣ ਤੋਂ ਬਚੋ।
                    2. ਪੌਦਿਆਂ ਦੀ ਦੂਰੀ ਨੂੰ ਬੰਦ ਕਰਨ ਨਾਲ ਪੱਤਿਆਂ ਦੀ ਘਣਤਾ ਵੱਧ ਜਾਂਦੀ ਹੈ ਜੋ ਉੱਚ ਹਿਸਪਾ ਸੰਖਿਆਵਾਂ ਨੂੰ ਬਰਦਾਸ਼ਤ ਕਰ ਸਕਦੀ ਹੈ।
                    3. ਪੱਤੇ ਦੀ ਨੋਕ ਜਿਸ ਵਿੱਚ ਧੱਬੇ ਵਾਲੀਆਂ ਖਾਣਾਂ ਹਨ ਨੂੰ ਨਸ਼ਟ ਕਰ ਦੇਣਾ ਚਾਹੀਦਾ ਹੈ।
                    4. ਬੀਟਲਾਂ ਨੂੰ ਹੱਥੀਂ ਇਕੱਠਾ ਕਰਨਾ ਅਤੇ ਮਾਰਨਾ - ਹੱਥ ਜਾਲ।
                    5. ਕੀੜਿਆਂ ਦੇ ਅੰਡੇ ਦੇਣ ਤੋਂ ਰੋਕਣ ਲਈ, ਸ਼ੂਟ ਟਿਪਸ ਨੂੰ ਕੱਟਿਆ ਜਾ ਸਕਦਾ ਹੈ।
                    6. ਚਿੱਕੜ ਵਿੱਚ ਟਹਿਣੀਆਂ ਨੂੰ ਕਲਿਪ ਕਰਨ ਅਤੇ ਦੱਬਣ ਨਾਲ ਗਰਬ ਦੀ ਆਬਾਦੀ 75 - 92% ਘਟ ਸਕਦੀ ਹੈ।
                    7.Reduviid ਬੱਗ ਬਾਲਗਾਂ ਨੂੰ ਖਾਂਦਾ ਹੈ।
                    8. ਮਿਥਾਈਲ ਪੈਰਾਥੀਓਨ 0.05% ਜਾਂ ਕੁਇਨਲਫੋਸ 0.05% ਦਾ ਛਿੜਕਾਅ।
                                       
                    ਸੱਭਿਆਚਾਰਕ ਢੰਗ:
                    1. ਤੁੰਗਰੋ ਵਾਇਰਸ ਰੋਗ ਦੇ ਵਿਰੁੱਧ ਰੋਧਕ ਕਿਸਮਾਂ ਦੀ ਬਿਜਾਈ ਕਰਨਾ ਬਿਮਾਰੀ ਦੇ ਪ੍ਰਬੰਧਨ ਦਾ ਸਭ ਤੋਂ ਵੱਧ ਕਿਫ਼ਾਇਤੀ ਸਾਧਨ ਹੈ।
                    2. ਰੋਧਕ ਕਿਸਮਾਂ ਜਿਵੇਂ ਕਿ IR 36, IR 50, ADT 37, Ponmani, Co 45, Co 48, Surekha, Vikramarya, Bharani, IR 36 ਅਤੇ ਚਿੱਟੀ ਪੋਨੀ ਦੀ ਵਰਤੋਂ ਕਰੋ।
                    3. ਸੱਭਿਆਚਾਰਕ ਪ੍ਰਬੰਧਨ ਅਭਿਆਸਾਂ ਵਿੱਚ, ਲਾਉਣਾ ਦੀ ਮਿਤੀ ਨੂੰ ਅਨੁਕੂਲ ਕਰਨ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ।
                    4. ਇਸੇ ਤਰ੍ਹਾਂ, ਬਿਮਾਰੀ ਦੇ ਮੇਜ਼ਬਾਨਾਂ ਅਤੇ ਵਾਇਰਸਾਂ ਅਤੇ ਵੈਕਟਰਾਂ ਨੂੰ ਖਤਮ ਕਰਨ ਲਈ ਘੱਟੋ-ਘੱਟ ਇੱਕ ਮਹੀਨੇ ਦੀ ਪਤਝੜ ਦੀ ਮਿਆਦ ਦਾ ਪਾਲਣ ਕਰਨਾ।
                    5. ਮਹਾਂਮਾਰੀ ਵਾਲੇ ਖੇਤਰਾਂ ਵਿੱਚ ਦਾਲਾਂ ਜਾਂ ਤੇਲ ਬੀਜਾਂ ਨਾਲ ਘੁੰਮਾਓ।
                    6. ਨਿੰਮ ਦਾ ਕੇਕ @ 12.5 ਕਿਲੋਗ੍ਰਾਮ/20 ਸੈਂਟੀ ਨਰਸਰੀ ਨੂੰ ਮੂਲ ਖੁਰਾਕ ਵਜੋਂ ਲਾਗੂ ਕਰੋ।
                    7. ਵਾਢੀ ਤੋਂ ਤੁਰੰਤ ਬਾਅਦ ਪਰਾਲੀ ਨੂੰ ਨਸ਼ਟ ਕਰਨ ਲਈ ਖੇਤ ਨੂੰ ਵਾਹੁਣ ਅਤੇ ਕਟਾਈ ਕਰਨ ਦੀ ਸਲਾਹ ਦਿੱਤੀ ਜਾਂਦੀ ਹੈ ਤਾਂ ਜੋ ਹੋਰ ਟੰਗਰੋ ਮੇਜ਼ਬਾਨਾਂ ਨੂੰ ਖਤਮ ਕੀਤਾ ਜਾ ਸਕੇ।
                    8. ਬੰਨ੍ਹਾਂ 'ਤੇ ਨਦੀਨਾਂ ਦੇ ਮੇਜ਼ਬਾਨਾਂ ਦਾ ਨਾਸ਼।
                                        
                    ਰਸਾਇਣਕ ਢੰਗ:
                    • ਪੱਤਿਆਂ ਦੇ ਪੀਲੇ ਹੋਣ ਨੂੰ ਮੈਨਕੋਜ਼ੇਬ ਨਾਲ 2% ਯੂਰੀਆ ਮਿਲਾ ਕੇ 2.5 ਗ੍ਰਾਮ ਪ੍ਰਤੀ ਲਿਟਰ ਦੇ ਹਿਸਾਬ ਨਾਲ ਛਿੜਕਾਅ ਕਰਕੇ ਘੱਟ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ।
                    • ਯੂਰੀਆ ਦੀ ਥਾਂ 'ਤੇ ਮਲਟੀ-ਕੇ (ਪੋਟਾਸ਼ੀਅਮ ਨਾਈਟ੍ਰੇਟ) ਵਰਗੀ ਖਾਦ ਦਾ 1 ਫੀਸਦੀ ਛਿੜਕਾਅ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ ਜੋ ਪੋਟਾਸ਼ੀਅਮ ਦੀ ਜ਼ਿਆਦਾ ਮਾਤਰਾ ਦੇ ਕਾਰਨ ਪ੍ਰਤੀਰੋਧ ਵੀ ਪ੍ਰਦਾਨ ਕਰਦਾ ਹੈ।
                    • ਵੈਕਟਰ ਦੇ ਤੌਰ 'ਤੇ ਹਰੇ ਪੱਤੇ ਹਾਪਰਾਂ ਨੂੰ ਸਮੇਂ ਸਿਰ ਸਪਰੇਅ ਕਰਕੇ ਪ੍ਰਭਾਵਸ਼ਾਲੀ ਢੰਗ ਨਾਲ ਨਿਯੰਤਰਿਤ ਕੀਤਾ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ।
                    • ਕੀਟਨਾਸ਼ਕਾਂ ਦਾ ਛਿੜਕਾਅ ਦੋ ਵਾਰ, 15 ਅਤੇ 30 ਦਿਨ ਬਾਅਦ ਕਰੋ
                                            
                    ਹੇਠਾਂ ਦਿੱਤੇ ਕੀਟਨਾਸ਼ਕਾਂ ਵਿੱਚੋਂ ਕਿਸੇ ਇੱਕ ਦੇ ਦੋ ਰਾਊਂਡ ਸਪਰੇਅ ਕਰੋ
                    ◦ ਮੋਨੋਕਰੋਟੋਫੋਸ 36 WSC (40 ml/ha)
                    ◦ ਫੈਂਥੀਓਨ 100 ਈਸੀ (40 ਮਿਲੀਲੀਟਰ/ਹੈਕਟੇਅਰ) ਦਾ ਛਿੜਕਾਅ ਬਿਜਾਈ ਤੋਂ 15 ਅਤੇ 30 ਦਿਨਾਂ ਬਾਅਦ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ।
                                            
                                            
                    ਵਧੇਰੇ ਜਾਣਕਾਰੀ ਲਈ https://farmer.gov.in/FarmerHome.aspx 'ਤੇ ਜਾਓ
                                            
                    ਜਾਂ ਕਿਸਾਨ ਕਾਲ ਸੈਂਟਰ (ਕੇਸੀਸੀ) ਨਾਲ ਸੰਪਰਕ ਕਰੋ (ਟੋਲ ਫ੍ਰੀ ਨੰਬਰ 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("Tungro")) {
            remedy.setText("""
                    ਜਾਲ ਦੇ ਤਰੀਕੇ:
                    ਲੀਫ ਹੌਪਰ ਵੈਕਟਰਾਂ ਨੂੰ ਆਕਰਸ਼ਿਤ ਕਰਨ ਅਤੇ ਨਿਯੰਤਰਣ ਕਰਨ ਦੇ ਨਾਲ-ਨਾਲ ਆਬਾਦੀ ਦੀ ਨਿਗਰਾਨੀ ਕਰਨ ਲਈ ਲਾਈਟ ਟਰੈਪ ਲਗਾਏ ਜਾਣੇ ਹਨ।
                    ਸਵੇਰੇ-ਸਵੇਰੇ, ਲਾਈਟ ਟ੍ਰੈਪ ਦੇ ਨੇੜੇ ਲੀਫਹਾਪਰ ਦੀ ਆਬਾਦੀ ਨੂੰ ਕੀਟਨਾਸ਼ਕਾਂ ਦਾ ਛਿੜਕਾਅ/ਧੂੜ ਪਾ ਕੇ ਮਾਰ ਦੇਣਾ ਚਾਹੀਦਾ ਹੈ। ਇਹ ਹਰ ਰੋਜ਼ ਅਭਿਆਸ ਕਰਨਾ ਚਾਹੀਦਾ ਹੈ.
                                        
                    ਸੱਭਿਆਚਾਰਕ ਢੰਗ:                    
                    ਤੁੰਗਰੋ ਵਾਇਰਸ ਰੋਗ ਦੇ ਵਿਰੁੱਧ ਰੋਧਕ ਕਿਸਮਾਂ ਦੀ ਬਿਜਾਈ ਕਰਨਾ ਬਿਮਾਰੀ ਦੇ ਪ੍ਰਬੰਧਨ ਦਾ ਸਭ ਤੋਂ ਵੱਧ ਕਿਫ਼ਾਇਤੀ ਸਾਧਨ ਹੈ।
                    ਰੋਧਕ ਕਿਸਮਾਂ ਜਿਵੇਂ ਕਿ IR 36, IR 50, ADT 37, Ponmani, Co 45, Co 48, ਸੁਰੇਖਾ, ਵਿਕਰਮਰੀਆ, ਭਰਾਨੀ, IR 36 ਅਤੇ ਚਿੱਟੀ ਪੋਨੀ ਦੀ ਵਰਤੋਂ ਕਰੋ।
                    ਸੱਭਿਆਚਾਰਕ ਪ੍ਰਬੰਧਨ ਅਭਿਆਸਾਂ ਵਿੱਚ, ਲਾਉਣਾ ਦੀ ਮਿਤੀ ਨੂੰ ਅਨੁਕੂਲ ਕਰਨ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ।
                     ਇਸੇ ਤਰ੍ਹਾਂ, ਬਿਮਾਰੀ ਦੇ ਮੇਜ਼ਬਾਨਾਂ ਅਤੇ ਵਾਇਰਸਾਂ ਅਤੇ ਵੈਕਟਰਾਂ ਨੂੰ ਖਤਮ ਕਰਨ ਲਈ ਘੱਟੋ-ਘੱਟ ਇੱਕ ਮਹੀਨੇ ਦੀ ਪਤਝੜ ਦੀ ਮਿਆਦ ਦਾ ਨਿਰੀਖਣ ਕਰਨਾ।
                     ਮਹਾਂਮਾਰੀ ਵਾਲੇ ਖੇਤਰਾਂ ਵਿੱਚ ਦਾਲਾਂ ਜਾਂ ਤੇਲ ਬੀਜਾਂ ਨਾਲ ਘੁੰਮਾਓ।
                    ਨਿੰਮ ਦਾ ਕੇਕ @ 12.5 ਕਿਲੋਗ੍ਰਾਮ/20 ਸੈਂਟੀ ਨਰਸਰੀ ਨੂੰ ਮੂਲ ਖੁਰਾਕ ਵਜੋਂ ਲਾਗੂ ਕਰੋ।
                    ਵਾਢੀ ਤੋਂ ਤੁਰੰਤ ਬਾਅਦ ਪਰਾਲੀ ਨੂੰ ਨਸ਼ਟ ਕਰਨ ਲਈ ਖੇਤ ਨੂੰ ਵਾਹੁਣਾ ਅਤੇ ਕਟਾਈ ਕਰਨਾ
                    ਹੋਰ ਟੁੰਗਰੋ ਮੇਜ਼ਬਾਨਾਂ ਦੇ ਖਾਤਮੇ ਦੀ ਵੀ ਸਲਾਹ ਦਿੱਤੀ ਜਾਂਦੀ ਹੈ।
                    ਬੰਨ੍ਹਾਂ 'ਤੇ ਨਦੀਨਾਂ ਦੇ ਮੇਜ਼ਬਾਨਾਂ ਦਾ ਵਿਨਾਸ਼।
                                        
                    ਰਸਾਇਣਕ ਢੰਗ:
                    ਮੈਨਕੋਜ਼ੇਬ ਨਾਲ 2% ਯੂਰੀਆ ਮਿਲਾ ਕੇ 2.5 ਗ੍ਰਾਮ ਪ੍ਰਤੀ ਲਿਟਰ ਦੇ ਹਿਸਾਬ ਨਾਲ ਛਿੜਕਾਅ ਕਰਕੇ ਪੱਤਿਆਂ ਦੇ ਪੀਲੇਪਣ ਨੂੰ ਘੱਟ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ।
                    ਯੂਰੀਆ ਦੀ ਥਾਂ 'ਤੇ ਮਲਟੀ-ਕੇ (ਪੋਟਾਸ਼ੀਅਮ ਨਾਈਟ੍ਰੇਟ) ਵਰਗੀ ਖਾਦ ਦਾ 1 ਫੀਸਦੀ ਛਿੜਕਾਅ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ ਜੋ ਪੋਟਾਸ਼ੀਅਮ ਦੀ ਜ਼ਿਆਦਾ ਮਾਤਰਾ ਕਾਰਨ ਰੋਗ ਪ੍ਰਤੀਰੋਧਕ ਸ਼ਕਤੀ ਪ੍ਰਦਾਨ ਕਰਦਾ ਹੈ।
                    ਵੈਕਟਰ ਦੇ ਤੌਰ 'ਤੇ ਹਰੇ ਪੱਤੇ ਹਾਪਰਾਂ ਨੂੰ ਸਪਰੇਅ ਕਰਕੇ ਸਮੇਂ ਸਿਰ ਪ੍ਰਭਾਵਸ਼ਾਲੀ ਢੰਗ ਨਾਲ ਕੰਟਰੋਲ ਕੀਤਾ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ।
                    ਬੰਨ੍ਹਾਂ 'ਤੇ ਬਨਸਪਤੀ ਨੂੰ ਵੀ ਕੀਟਨਾਸ਼ਕਾਂ ਦਾ ਛਿੜਕਾਅ ਕਰਨਾ ਚਾਹੀਦਾ ਹੈ। ਨਰਸਰੀ ਵਿੱਚ 2.5 ਸੈਂਟੀਮੀਟਰ ਪਾਣੀ ਰੱਖੋ ਅਤੇ ਹੇਠਾਂ ਦਿੱਤੇ ਵਿੱਚੋਂ ਕਿਸੇ ਨੂੰ ਵੀ 20 ਸੈਂਟ ਕਾਰਬੋਫੁਰਾਨ 3 ਜੀ 3.5 ਕਿਲੋਗ੍ਰਾਮ (ਜਾਂ) ਫੋਰੇਟ 10 ਜੀ 1.0 ਕਿਲੋਗ੍ਰਾਮ (ਜਾਂ) ਕੁਇਨਲਫੋਸ 5 ਜੀ 2.0 ਕਿਲੋਗ੍ਰਾਮ ਵਿੱਚ ਪ੍ਰਸਾਰਿਤ ਕਰੋ।
                    ਨਰਸਰੀ ਵਿੱਚ ਜਦੋਂ ਵਾਇਰਸ ਦੀ ਲਾਗ ਘੱਟ ਹੁੰਦੀ ਹੈ, ਤਾਂ ਵੈਕਟਰ ਆਬਾਦੀ ਨੂੰ ਕੰਟਰੋਲ ਕਰਨ ਲਈ ਕਾਰਬੋਫੁਰਾਨ ਗ੍ਰੈਨਿਊਲ @ 1 ਕਿਲੋਗ੍ਰਾਮ ਪ੍ਰਤੀ ਹੈਕਟੇਅਰ ਲਾਗੂ ਕਰੋ।
                    ਪ੍ਰੀ-ਟਿਲਰਿੰਗ ਤੋਂ ਲੈ ਕੇ ਮੱਧ-ਟਿਲਰਿੰਗ ਦੌਰਾਨ ਜਦੋਂ ਇੱਕ ਪ੍ਰਭਾਵਿਤ ਪਹਾੜੀ/ਮੀਟਰ ਦੇਖਿਆ ਜਾਂਦਾ ਹੈ ਤਾਂ ਕੀਟ ਵੈਕਟਰ ਨੂੰ ਨਿਯੰਤਰਿਤ ਕਰਨ ਲਈ ਕਾਰਬੋਫੁਰਾਨ ਗ੍ਰੈਨਿਊਲ @ 3.5 ਕਿਲੋਗ੍ਰਾਮ ਪ੍ਰਤੀ ਹੈਕਟੇਅਰ ਦੀ ਵਰਤੋਂ ਸ਼ੁਰੂ ਕਰੋ।
                    ਹੇਠਾਂ ਦਿੱਤੇ ਕੀਟਨਾਸ਼ਕਾਂ ਵਿੱਚੋਂ ਕਿਸੇ ਇੱਕ ਦੇ ਦੋ ਰਾਊਂਡ ਸਪਰੇਅ ਕਰੋ
                    ਥਿਆਮੇਥੋਕਸਮ 25 ਡਬਲਯੂਡੀਜੀ 100 ਗ੍ਰਾਮ / ਹੈਕਟੇਅਰ (ਜਾਂ)
                    ਇਮੀਡਾਕਲੋਪ੍ਰਿਡ 17.8 SL 100 ਮਿ.ਲੀ./ਹੈਕਟੇਅਰ 15 ਅਤੇ 30 ਦਿਨਾਂ ਬਾਅਦ ਬੀਜੋ। ਬੰਨ੍ਹਾਂ 'ਤੇ ਲੱਗੀ ਬਨਸਪਤੀ 'ਤੇ ਵੀ ਕੀਟਨਾਸ਼ਕਾਂ ਦਾ ਛਿੜਕਾਅ ਕਰਨਾ ਚਾਹੀਦਾ ਹੈ।

                    ਵਧੇਰੇ ਜਾਣਕਾਰੀ ਲਈ https://farmer.gov.in/FarmerHome.aspx 'ਤੇ ਜਾਓ


                    ਜਾਂ ਕਿਸਾਨ ਕਾਲ ਸੈਂਟਰ (ਕੇਸੀਸੀ) ਨਾਲ ਸੰਪਰਕ ਕਰੋ (ਟੋਲ ਫ੍ਰੀ ਨੰਬਰ 1800-180-1551)""");
        } else {
            remedy.setText("ਤੁਹਾਡੇ ਕੋਲ ਸਿਹਤਮੰਦ ਫਸਲ ਹੈ।");
        }
        remedy.setChatId(chatId);
        return remedy;
    }


    private SendMessage wheatDiseaseEnglish(String disease, Long chatId) {
        SendMessage remedy = new SendMessage();
        if (disease.equalsIgnoreCase("LEAF RUST") || disease.equalsIgnoreCase("STEM RUST") || disease.equalsIgnoreCase("YELLOW RUST")) {
            remedy.setText("""
                    Most effective method for control of rust, is to grow rust-resistant varieties. 
                    Biodiversity among wheat cultivars can also effectively check the rust problem. 
                    Use 3-4 wheat varieties at a time on each farm. Avoid late sowing or late 
                    maturing varieties. To protect the crop from rust infection, spray 5 liters of 
                    sour buttermilk mixed with 200 liter of water. Amaranth (chaulai or lal bhaji – 
                    a common green leaf vegetable) or Mentha (Pudina) leaf dust can also be used as 
                    fine spray (25- 30 gm dry leaf powder per lit of water) to prevent the infection 
                    of rusts. Foliar spray of dry leaf extract of Hibiscus rosa-sinensis (China 
                    rose) can also prevent the rust infection.


                    FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx


                    OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551) """);

        } else if (disease.equalsIgnoreCase("POWDERY MILDEW")) {
            remedy.setText("""
                    1. Grow varieties resistant to the diseases.
                    2. Bum crop refuse in the field after the harvest is over.
                    3. If loss is expected to be high, spraying with a mixture of Dithane M-45 and
                    Karathane has been found beneficial. Prepare mixture by mixing 16 parts of
                    Dithane M-45 and 4 parts of Karathane-25 wettable powder. Spray mixture @ 2
                    kg/ha dissolved in 1000 litres of water. About three sprays will be sufficient
                    at an interval of 10-15 days. Amount of water for different sprays may be
                    decided on the basis of growing stage of the crop.


                    FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx


                    OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("SEPTORIA")) {
            remedy.setText("""
                    Grow a variety with a high septoria tritici resistance rating
                    Avoid early drilling, especially of susceptible varieties
                    The T2 fungicide timing is the most crucial, with T1 also targeted at septoria tritici control. However, the T0 spray rarely gives a yield benefit
                    Use a balanced mixture of an azole with a multisite (where possible). Only add an SDHI when disease risk merits it
                    Use the lowest dose possible to get the required control, but ensure that each component of the mix gives comparable levels of control


                    FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx
                    %0A%0A
                    OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("SEEDLING")) {
            remedy.setText("NO REMEDY AVAILABLE");
        } else {
            remedy.setText("YOU HAVE HEALTHY CROP");
        }
        remedy.setChatId(chatId);
        return remedy;
    }

    private SendMessage wheatDiseaseHindi(String disease, Long chatId) {
        SendMessage remedy = new SendMessage();
        if (disease.equalsIgnoreCase("LEAF RUST") || disease.equalsIgnoreCase("STEM RUST") || disease.equalsIgnoreCase("YELLOW RUST")) {
            remedy.setText("""
                    जंग के नियंत्रण के लिए सबसे प्रभावी तरीका, जंग प्रतिरोधी किस्मों को उगाना है।
                    गेहूं की किस्मों के बीच जैव विविधता भी जंग की समस्या को प्रभावी ढंग से रोक सकती है।
                    प्रत्येक खेत में एक बार में 3-4 गेहूं की किस्मों का प्रयोग करें। देर से बुवाई या देर से करने से बचें
                    परिपक्व किस्में। फसल को जंग के संक्रमण से बचाने के लिए 5 लीटर का छिड़काव करें
                    खट्टा छाछ 200 लीटर पानी में मिलाया जाता है। अमरनाथ (चौलाई या लाल भाजी -
                    एक आम हरी पत्ती वाली सब्जी) या मेंथा (पुदीना) की पत्ती की धूल का भी इस्तेमाल किया जा सकता है
                    संक्रमण को रोकने के लिए बारीक स्प्रे (25- 30 ग्राम सूखे पत्तों का पाउडर प्रति लीटर पानी)
                    जंग का। हिबिस्कस रोजा-सिनेंसिस (चीन) के सूखे पत्तों के अर्क का पर्ण स्प्रे
                    गुलाब) जंग के संक्रमण को भी रोक सकता है।


                    अधिक जानकारी के लिए देखें https://farmer.gov.in/FarmerHome.aspx


                    या किसान कॉल सेंटर (केसीसी) से संपर्क करें (टोल फ्री नंबर 1800-180-1551) """);

        } else if (disease.equalsIgnoreCase("POWDERY MILDEW")) {
            remedy.setText("""
                    1. रोगों के लिए प्रतिरोधी किस्मों को उगाएं।
                    2. फसल खत्म होने के बाद खेत में बुम फसल का कचरा।
                    3. यदि नुकसान अधिक होने की आशंका हो तो डाइथेन एम-45 और . के मिश्रण का छिड़काव करें
                    कराठाणे को लाभकारी पाया गया है। के 16 भाग मिलाकर मिश्रण तैयार करें
                    डाइथेन एम-45 और कराथेन-25 वेटेबल पाउडर के 4 भाग। स्प्रे मिश्रण @ 2
                    किलो/हेक्टेयर 1000 लीटर पानी में घोला गया। लगभग तीन स्प्रे पर्याप्त होंगे
                    10-15 दिनों के अंतराल पर। विभिन्न स्प्रे के लिए पानी की मात्रा हो सकती है
                    फसल की बढ़ती अवस्था के आधार पर निर्णय लिया जाता है।

                    अधिक जानकारी के लिए देखें https://farmer.gov.in/FarmerHome.aspx
                    या किसान कॉल सेंटर (केसीसी) से संपर्क करें (टोल फ्री नंबर 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("SEPTORIA")) {
            remedy.setText("""
                    उच्च सेप्टोरिया ट्रिटिक प्रतिरोध रेटिंग के साथ एक किस्म उगाएं
                    शुरुआती ड्रिलिंग से बचें, विशेष रूप से अतिसंवेदनशील किस्मों की
                    T2 कवकनाशी का समय सबसे महत्वपूर्ण है, T1 के साथ सेप्टोरिया ट्रिटिक नियंत्रण पर भी लक्षित है। हालांकि, T0 स्प्रे शायद ही कभी उपज लाभ देता है
                    एक मल्टीसाइट (जहां संभव हो) के साथ एज़ोल के संतुलित मिश्रण का उपयोग करें। एक SDHI तभी जोड़ें जब बीमारी का जोखिम इसके लायक हो
                    आवश्यक नियंत्रण प्राप्त करने के लिए संभव न्यूनतम खुराक का उपयोग करें, लेकिन सुनिश्चित करें कि मिश्रण का प्रत्येक घटक नियंत्रण के तुलनीय स्तर देता है

                    अधिक जानकारी के लिए देखें https://farmer.gov.in/FarmerHome.aspx
                    या किसान कॉल सेंटर (केसीसी) से संपर्क करें (टोल फ्री नंबर 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("SEEDLING")) {
            remedy.setText("कोई उपाय उपलब्ध नहीं");
        } else {
            remedy.setText("आपके पास स्वस्थ फसल है");
        }
        remedy.setChatId(chatId);
        return remedy;
    }

    private SendMessage wheatDiseasePunjabi(String disease, Long chatId) {
        SendMessage remedy = new SendMessage();
        if (disease.equalsIgnoreCase("LEAF RUST") || disease.equalsIgnoreCase("STEM RUST") || disease.equalsIgnoreCase("YELLOW RUST")) {
            remedy.setText("""
                    ਜੰਗਾਲ ਦੇ ਨਿਯੰਤਰਣ ਲਈ ਸਭ ਤੋਂ ਪ੍ਰਭਾਵਸ਼ਾਲੀ ਤਰੀਕਾ, ਜੰਗਾਲ-ਰੋਧਕ ਕਿਸਮਾਂ ਨੂੰ ਉਗਾਉਣਾ ਹੈ।
                    ਕਣਕ ਦੀਆਂ ਕਿਸਮਾਂ ਵਿੱਚ ਜੈਵ ਵਿਭਿੰਨਤਾ ਵੀ ਜੰਗਾਲ ਦੀ ਸਮੱਸਿਆ ਨੂੰ ਪ੍ਰਭਾਵਸ਼ਾਲੀ ਢੰਗ ਨਾਲ ਰੋਕ ਸਕਦੀ ਹੈ।
                    ਹਰੇਕ ਖੇਤ ਵਿੱਚ ਇੱਕ ਵਾਰ ਵਿੱਚ 3-4 ਕਣਕ ਦੀਆਂ ਕਿਸਮਾਂ ਦੀ ਵਰਤੋਂ ਕਰੋ। ਪਛੇਤੀ ਜਾਂ ਪਛੇਤੀ ਬਿਜਾਈ ਤੋਂ ਬਚੋ
                    ਪੱਕਣ ਵਾਲੀਆਂ ਕਿਸਮਾਂ. ਫਸਲ ਨੂੰ ਜੰਗਾਲ ਦੀ ਲਾਗ ਤੋਂ ਬਚਾਉਣ ਲਈ 5 ਲੀਟਰ ਦਾ ਛਿੜਕਾਅ ਕਰੋ
                    200 ਲੀਟਰ ਪਾਣੀ ਵਿੱਚ ਖੱਟੀ ਮੱਖਣ ਮਿਲਾਓ। ਅਮਰੰਥ (ਚੌਲਈ ਜਾਂ ਲਾਲ ਭਾਜੀ -
                    ਇੱਕ ਆਮ ਹਰੇ ਪੱਤੇ ਦੀ ਸਬਜ਼ੀ) ਜਾਂ ਮੈਂਥਾ (ਪੁਦੀਨਾ) ਪੱਤੇ ਦੀ ਧੂੜ ਨੂੰ ਵੀ ਵਰਤਿਆ ਜਾ ਸਕਦਾ ਹੈ
                    ਲਾਗ ਨੂੰ ਰੋਕਣ ਲਈ ਬਾਰੀਕ ਸਪਰੇਅ (25-30 ਗ੍ਰਾਮ ਸੁੱਕੇ ਪੱਤਿਆਂ ਦਾ ਪਾਊਡਰ ਪ੍ਰਤੀ ਲਿਟਰ ਪਾਣੀ)
                    ਜੰਗਾਲ ਦੇ. ਹਿਬਿਸਕਸ ਰੋਜ਼ਾ-ਸਿਨੇਨਸਿਸ (ਚੀਨ
                    ਗੁਲਾਬ) ਜੰਗਾਲ ਦੀ ਲਾਗ ਨੂੰ ਵੀ ਰੋਕ ਸਕਦਾ ਹੈ।


                    ਵਧੇਰੇ ਜਾਣਕਾਰੀ ਲਈ https://farmer.gov.in/FarmerHome.aspx 'ਤੇ ਜਾਓ


                    ਜਾਂ ਕਿਸਾਨ ਕਾਲ ਸੈਂਟਰ (ਕੇਸੀਸੀ) ਨਾਲ ਸੰਪਰਕ ਕਰੋ (ਟੋਲ ਫ੍ਰੀ ਨੰਬਰ 1800-180-1551) """);

        } else if (disease.equalsIgnoreCase("POWDERY MILDEW")) {
            remedy.setText("""
                    1. ਬਿਮਾਰੀਆਂ ਪ੍ਰਤੀ ਰੋਧਕ ਕਿਸਮਾਂ ਉਗਾਓ।
                    2. ਵਾਢੀ ਦੇ ਖਤਮ ਹੋਣ ਤੋਂ ਬਾਅਦ ਖੇਤ ਵਿੱਚ ਝਾੜੀਆਂ ਦੀ ਫਸਲ ਨੂੰ ਛੱਡ ਦਿਓ।
                    3. ਜੇਕਰ ਨੁਕਸਾਨ ਜ਼ਿਆਦਾ ਹੋਣ ਦੀ ਸੰਭਾਵਨਾ ਹੈ, ਤਾਂ ਡਾਇਥੇਨ ਐਮ-45 ਦੇ ਮਿਸ਼ਰਣ ਨਾਲ ਛਿੜਕਾਅ ਕਰੋ।
                    ਕਰਥਾਨੇ ਨੂੰ ਲਾਭਦਾਇਕ ਪਾਇਆ ਗਿਆ ਹੈ। ਦੇ 16 ਹਿੱਸੇ ਮਿਲਾ ਕੇ ਮਿਸ਼ਰਣ ਤਿਆਰ ਕਰੋ
                    ਡਾਇਥੇਨ ਐੱਮ-45 ਅਤੇ ਕਰਾਥੇਨ-25 ਵੇਟੇਬਲ ਪਾਊਡਰ ਦੇ 4 ਹਿੱਸੇ। @2 ਮਿਸ਼ਰਣ ਦਾ ਛਿੜਕਾਅ ਕਰੋ
                    ਕਿਲੋਗ੍ਰਾਮ/ਹੈਕਟੇਅਰ 1000 ਲੀਟਰ ਪਾਣੀ ਵਿੱਚ ਘੋਲਿਆ ਜਾਂਦਾ ਹੈ। ਲਗਭਗ ਤਿੰਨ ਸਪਰੇਆਂ ਕਾਫੀ ਹੋਣਗੀਆਂ
                    10-15 ਦਿਨਾਂ ਦੇ ਅੰਤਰਾਲ 'ਤੇ. ਵੱਖ-ਵੱਖ ਸਪਰੇਆਂ ਲਈ ਪਾਣੀ ਦੀ ਮਾਤਰਾ ਹੋ ਸਕਦੀ ਹੈ
                    ਫਸਲ ਦੇ ਵਧਣ ਦੇ ਪੜਾਅ ਦੇ ਆਧਾਰ 'ਤੇ ਫੈਸਲਾ ਕੀਤਾ ਜਾਂਦਾ ਹੈ।


                    ਵਧੇਰੇ ਜਾਣਕਾਰੀ ਲਈ https://farmer.gov.in/FarmerHome.aspx 'ਤੇ ਜਾਓ


                    ਜਾਂ ਕਿਸਾਨ ਕਾਲ ਸੈਂਟਰ (ਕੇਸੀਸੀ) ਨਾਲ ਸੰਪਰਕ ਕਰੋ (ਟੋਲ ਫ੍ਰੀ ਨੰਬਰ 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("SEPTORIA")) {
            remedy.setText("""
                    ਇੱਕ ਉੱਚ ਸੇਪਟੋਰੀਆ ਟ੍ਰਾਈਟੀਸੀ ਪ੍ਰਤੀਰੋਧ ਰੇਟਿੰਗ ਦੇ ਨਾਲ ਇੱਕ ਕਿਸਮ ਉਗਾਓ
                    ਅਗੇਤੀ ਡ੍ਰਿਲਿੰਗ ਤੋਂ ਬਚੋ, ਖਾਸ ਕਰਕੇ ਸੰਵੇਦਨਸ਼ੀਲ ਕਿਸਮਾਂ ਦੀ
                    T2 ਉੱਲੀਨਾਸ਼ਕ ਸਮਾਂ ਸਭ ਤੋਂ ਮਹੱਤਵਪੂਰਨ ਹੈ, T1 ਦੇ ਨਾਲ ਸੇਪਟੋਰੀਆ ਟ੍ਰਾਈਟੀਸੀ ਨਿਯੰਤਰਣ ਨੂੰ ਵੀ ਨਿਸ਼ਾਨਾ ਬਣਾਇਆ ਗਿਆ ਹੈ। ਹਾਲਾਂਕਿ, T0 ਸਪਰੇਅ ਘੱਟ ਹੀ ਝਾੜ ਦਾ ਲਾਭ ਦਿੰਦੀ ਹੈ
                    ਮਲਟੀਸਾਈਟ (ਜਿੱਥੇ ਸੰਭਵ ਹੋਵੇ) ਦੇ ਨਾਲ ਇੱਕ ਅਜ਼ੋਲ ਦੇ ਸੰਤੁਲਿਤ ਮਿਸ਼ਰਣ ਦੀ ਵਰਤੋਂ ਕਰੋ। ਸਿਰਫ਼ ਉਦੋਂ ਹੀ ਇੱਕ SDHI ਸ਼ਾਮਲ ਕਰੋ ਜਦੋਂ ਬਿਮਾਰੀ ਦੇ ਜੋਖਮ ਦੇ ਯੋਗ ਹੋਣ
                    ਲੋੜੀਂਦਾ ਨਿਯੰਤਰਣ ਪ੍ਰਾਪਤ ਕਰਨ ਲਈ ਸਭ ਤੋਂ ਘੱਟ ਖੁਰਾਕ ਦੀ ਵਰਤੋਂ ਕਰੋ, ਪਰ ਇਹ ਸੁਨਿਸ਼ਚਿਤ ਕਰੋ ਕਿ ਮਿਸ਼ਰਣ ਦਾ ਹਰੇਕ ਹਿੱਸਾ ਨਿਯੰਤਰਣ ਦੇ ਤੁਲਨਾਤਮਕ ਪੱਧਰ ਦਿੰਦਾ ਹੈ।


                    ਵਧੇਰੇ ਜਾਣਕਾਰੀ ਲਈ https://farmer.gov.in/FarmerHome.aspx 'ਤੇ ਜਾਓ
                    %0A%0A
                    ਜਾਂ ਕਿਸਾਨ ਕਾਲ ਸੈਂਟਰ (ਕੇਸੀਸੀ) ਨਾਲ ਸੰਪਰਕ ਕਰੋ (ਟੋਲ ਫ੍ਰੀ ਨੰਬਰ 1800-180-1551) """);
        } else if (disease.equalsIgnoreCase("SEEDLING")) {
            remedy.setText("ਕੋਈ ਉਪਾਅ ਉਪਲਬਧ ਨਹੀਂ");
        } else {
            remedy.setText("ਤੁਹਾਡੇ ਕੋਲ ਸਿਹਤਮੰਦ ਫਸਲ ਹੈ");
        }
        remedy.setChatId(chatId);
        return remedy;
    }
}