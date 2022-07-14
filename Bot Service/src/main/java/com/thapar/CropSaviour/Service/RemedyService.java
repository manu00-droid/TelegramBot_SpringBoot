package com.thapar.CropSaviour.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemedyService {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    TranslateService translateService;

    public String riceDiseaseRemedy(String disease, Long chatId) {
        String remedy;
        if (disease.equalsIgnoreCase("Bacterial Blight")) {
            remedy = "BACTERIAL BLIGHT REMEDIES\n" +
                    "\n" +
                    "Preventive method\n" +
                    "1.Seed treatment with bleaching powder (100g/l) and zinc sulfate (2%) reduce bacterial blight.\n" +
                    "2.Seed treatment - seed soaking for 8 hours in Agrimycin (0.025%) and wettable ceresan (0.05%) followed by hot water treatment for 30 min at 52-54oC;\n" +
                    "3.seed soaking for 8 hours in ceresan (0.1%) and treat with Streptocyclin (3g in 1 litre);\n" +
                    "4.Spray neem oil 3% or NSKE 5%\n" +
                    "5.Spray fresh cowdung extract for the control of bacterial blight. Dissolve 20 g cowdung in one litre of water; allow to settle and sieve. Use supernatant liquid. (starting from initial appearance of the disease and another at fortnightly interval)\n" +
                    "Cultural methods\n" +
                    "1.Grow nurseries preferably in isolated upland conditions\n" +
                    "2.Avoid clipping of seedlings during transplanting.\n" +
                    "3.Drain the field (except at flowering stage of the crop)\n" +
                    "4.Destruction of weeds and  collateral hosts\n" +
                    "5.Avoid flow of water from affected fields\n" +
                    "6.Maintain proper plant spacing\n" +
                    "\n" +
                    "\n" +
                    "FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx\n" +
                    "\n" +
                    "OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551)";
        } else if (disease.equalsIgnoreCase("Blast") || disease.equalsIgnoreCase("Leaf Blast")) {
            remedy = "BLAST REMEDIES\n" +
                    "Preventive Measures \n" +
                    "1. Use healthy or certified seed material.\n" +
                    "2. Plant resistant varieties available in the area.\n" +
                    "3. Sow seeds early in the season, after the onset of the rainy season. \n" +
                    "4. Avoid excessive nitrogen fertilization and split the applications into two \n" +
                    "or more treatments. \n" +
                    "5. Avoid drought stress to the plants with regular irrigation. \n" +
                    "6. Keep a proper flood level for the rice to grow properly. \n" +
                    "7. Maintain continuous flooding and avoid drainage of the rice field. \n" +
                    "8. Maintain control of weeds and alternative hosts. \n" +
                    "9. Apply silicon fertilizers if the soil is known to be silicon deficient. \n" +
                    "10. Cheap sources of silicon include straws of rice varieties with the high \n" +
                    "silicon content. \n" +
                    "11. Monitor your field regularly for symptoms. \n" +
                    "12. Destroy all infected plant residues to prevent the carry-over of the fungus \n" +
                    "in the field. \n" +
                    "13. Plan a crop rotation as a simple and effective way to reduce populations.\n" +
                    "\n" +
                    "\n" +
                    "FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx\n" +
                    "\n" +
                    "OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551)";
        } else if (disease.equalsIgnoreCase("Brownspot")) {
            remedy = "BROWN SPOT REMEDIES\n" +
                    "\n" +
                    "Cultural methods\n" +
                    "1.As disease is seed borne,Use disease free seeds.\n" +
                    "2.Removal of alternate & collateral hosts.\n" +
                    "3.The use of resistant varieties is the most economical means of control.\n" +
                    "4.Growing Resistant varieties like ADT 44,PY 4,CORH 1,CO 44,CAUVERY,BHAVANI,TPS 4 and Dhanu.\n" +
                    "5.Providing proper nutrition for optimum plant growth and prevention of water stress seem to be the most important factors in controlling brown spot.\n" +
                    "\n" +
                    "Preventive methods\n" +
                    "1.Seed treatment with Pseudomonas fluorescens @ 10g/kg of seed followed by seedling dip @ of 2.5 kg or products/ha dissolved in 100 litres and dipping for 30 minutes.\n" +
                    "2.seed soak / seed treatment with Captan or  Thiram at 2.0g /kg of seed\n" +
                    "3.Since the fungus is seed transmitted, a hot water seed treatment (53-54°C) for 10-12 minutes may be effective before sowing. This treatment controls primary infection at the seedling stage. Presoaking the seed in cold water for 8 hours increases effectivity of the treatment.\n" +
                    "\n" +
                    "\n" +
                    "FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx\n" +
                    "\n" +
                    "OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551)";
        } else if (disease.equalsIgnoreCase("Hispa")) {
            remedy = "1.Avoid over fertilizing the field.\n" +
                    "2.Close plant spacing results in greater leaf densities that can tolerate higher hispa numbers.\n" +
                    "3.Leaf tip containing blotch mines should be destroyed.\n" +
                    "4.Manual collection and killing of beetles – hand nets.\n" +
                    "5.To prevent egg laying of the pests, the shoot tips can be cut.\n" +
                    "6.Clipping and burying shoots in the mud can reduce grub populations by 75 - 92%.\n" +
                    "7.Reduviid bug eats upon the adults.\n" +
                    "8.Spraying of methyl parathion 0.05% or Quinalphos 0.05%.\n" +
                    "1.Light traps are to be set up to attract and control the leaf hopper vectors as well as to monitor the population.\n" +
                    "2.In the early morning, the population of leafhopper alighting near the light trap should be killed by spraying/dusting the insecticides.\n" +
                    "3.This should be practiced every day.\n" +
                    "\n" +
                    "Cultural methods\n" +
                    "1. Planting of resistant varieties against tungro virus disease is the most economical means of managing the disease.\n" +
                    "2. Use  Resistant varieties like IR 36,  IR 50 ,ADT 37,  Ponmani, Co 45, Co 48, Surekha, Vikramarya, Bharani, IR 36   and white ponni .\n" +
                    "3. Among the cultural management practices, adjusting the date of planting is recommended.\n" +
                    "4.  Likewise, observing a fallow period of at least a month to eliminate hosts and viruses and vectors of the disease.\n" +
                    "5.  In epidemic areas follow rotation with pulses or oil seeds.\n" +
                    "6. Apply neem cake @ 12.5 kg/20 cent nursery as basal dose.\n" +
                    "7.  plouging and harrowing the field to destroy stubbles right after harvest in order to eradicate other tungro hosts are also advisable.\n" +
                    "8. Destruction of weed hosts on bunds.\n" +
                    "\n" +
                    "Chemical methods\n" +
                    "•  Leaf yellowing can be minimized by spraying 2 % urea mixed with Mancozeb at 2.5 gm/lit.\n" +
                    "• Instead of urea foliar fertilizer like multi-K (potassium nitrate) can be sprayed at 1 per cent which impart resistance also because of high potassium content.\n" +
                    "• Green leaf hoppers as vectors are to be controlled effectively in time by spraying.\n" +
                    "• Spray insecticides twice, 15 and 30 days after transplanting\n" +
                    "\n" +
                    "Spray Two rounds of any one of the following insecticides\n" +
                    "◦ Monocrotophos 36 WSC (40 ml/ha)\n" +
                    "◦ Fenthion 100 EC (40 ml/ha) may be sprayed 15 and 30 days after transplanting.\n" +
                    "\n" +
                    "\n" +
                    "FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx\n" +
                    "\n" +
                    "OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551)";
        } else if (disease.equalsIgnoreCase("Tungro")) {
            remedy = "Trap methods:\n" +
                    "\n" +
                    "Light traps are to be set up to attract and control the leaf hopper vectors as well as to monitor the population.\n" +
                    "In the early morning, the population of leafhopper alighting near the light trap should be killed by spraying/dusting the insecticides. This should be practiced every day.\n" +
                    "Cultural methods:\n" +
                    "\n" +
                    "Planting of resistant varieties against tungro virus disease is the most economical means of managing the disease.\n" +
                    "Use  resistant varieties like IR 36,  IR 50, ADT 37,  Ponmani, Co 45, Co 48, Surekha, Vikramarya, Bharani, IR 36 and white ponni .\n" +
                    "Among the cultural management practices, adjusting the date of planting is recommended.\n" +
                    " Likewise, observing a fallow period of at least a month to eliminate hosts and viruses and vectors of the disease.\n" +
                    " In epidemic areas follow rotation with pulses or oil seeds.\n" +
                    "Apply neem cake @ 12.5 kg/20 cent nursery as basal dose.\n" +
                    "Plouging and harrowing the field to destroy stubbles right after harvest\n" +
                    "Eradicate of other tungro hosts are also advisable.\n" +
                    "Destruction of weed hosts on bunds.\n" +
                    "Chemical methods:\n" +
                    "\n" +
                    "Leaf yellowing can be minimized by spraying 2 % urea mixed with Mancozeb at 2.5 gm/lit.\n" +
                    "Instead of urea foliar fertilizer like multi-K (potassium nitrate) can be sprayed at 1 per cent which impart disease resistance because of high potassium content.\n" +
                    "Green leaf hoppers as vectors are to be controlled effectively in time by spraying.\n" +
                    "Vegetation on the bunds should also be sprayed with the insecticides. Maintain 2.5 cm of water in the nursery and broadcast anyone of the following in 20 cents Carbofuran 3 G 3.5 kg (or) Phorate 10 G 1.0 kg (or) Quinalphos 5 G 2.0 kg.\n" +
                    "In nursery when virus infection is low, apply Carbofuran granules @ 1 kg/ha to control vector population.\n" +
                    "During pre-tillering to mid-tillering when one affected hill/m is observed start application of Carbofuran granules @ 3.5kg/ha to control insect vector.\n" +
                    "Spray Two rounds of any one of the following insecticides\n" +
                    "Thiamethoxam 25 WDG 100g/ha (or)\n" +
                    "Imidacloprid 17.8 SL 100ml/ha at 15 and 30 days after transplanting. The vegetation on the bunds should also be sprayed with the insecticides.  \n" +
                    "\n" +
                    "FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx\n" +
                    "\n" +
                    "\n" +
                    "OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551) ";
        } else {
            remedy = "You have healthy crop";
        }
        String language = userInfoService.getLanguageByChatId(chatId);
        remedy = translateService.translateData(remedy, language);
        return remedy;
    }

    public String wheatDiseaseRemedy(String disease, Long chatId) {
        String remedy;
        if (disease.equalsIgnoreCase("LEAF RUST") || disease.equalsIgnoreCase("STEM RUST") || disease.equalsIgnoreCase("YELLOW RUST")) {
            remedy = "Most effective method for control of rust, is to grow rust-resistant varieties. \n" +
                    "Biodiversity among wheat cultivars can also effectively check the rust problem. \n" +
                    "Use 3-4 wheat varieties at a time on each farm. Avoid late sowing or late \n" +
                    "maturing varieties. To protect the crop from rust infection, spray 5 liters of \n" +
                    "sour buttermilk mixed with 200 liter of water. Amaranth (chaulai or lal bhaji – \n" +
                    "a common green leaf vegetable) or Mentha (Pudina) leaf dust can also be used as \n" +
                    "fine spray (25- 30 gm dry leaf powder per lit of water) to prevent the infection \n" +
                    "of rusts. Foliar spray of dry leaf extract of Hibiscus rosa-sinensis (China \n" +
                    "rose) can also prevent the rust infection.\n" +
                    "\n" +
                    "\n" +
                    "FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx\n" +
                    "\n" +
                    "\n" +
                    "OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551) ";
        } else if (disease.equalsIgnoreCase("POWDERY MILDEW")) {
            remedy = "1. Grow varieties resistant to the diseases.\n" +
                    "2. Bum crop refuse in the field after the harvest is over.\n" +
                    "3. If loss is expected to be high, spraying with a mixture of Dithane M-45 and \n" +
                    "Karathane has been found beneficial. Prepare mixture by mixing 16 parts of \n" +
                    "Dithane M-45 and 4 parts of Karathane-25 wettable powder. Spray mixture @ 2 \n" +
                    "kg/ha dissolved in 1000 litres of water. About three sprays will be sufficient \n" +
                    "at an interval of 10-15 days. Amount of water for different sprays may be \n" +
                    "decided on the basis of growing stage of the crop.\n" +
                    "\n" +
                    "\n" +
                    "FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx\n" +
                    "\n" +
                    "\n" +
                    "OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551)";
        } else if (disease.equalsIgnoreCase("SEPTORIA")) {
            remedy = "Grow a variety with a high septoria tritici resistance rating\n" +
                    "Avoid early drilling, especially of susceptible varieties\n" +
                    "The T2 fungicide timing is the most crucial, with T1 also targeted at septoria tritici control. However, the T0 spray rarely gives a yield benefit\n" +
                    "Use a balanced mixture of an azole with a multisite (where possible). Only add an SDHI when disease risk merits it\n" +
                    "Use the lowest dose possible to get the required control, but ensure that each component of the mix gives comparable levels of control\n" +
                    "\n" +
                    "\n" +
                    "FOR MORE INFO VISIT https://farmer.gov.in/FarmerHome.aspx\n" +
                    "\n" +
                    "\n" +
                    "OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551)";
        } else if (disease.equalsIgnoreCase("SEEDLING")) {
            remedy = "NO REMEDY AVAILABLE";
        } else {
            remedy = "YOU HAVE HEALTHY CROP";
        }
        String language = userInfoService.getLanguageByChatId(chatId);
        remedy = translateService.translateData(remedy, language);
        return remedy;
    }
}