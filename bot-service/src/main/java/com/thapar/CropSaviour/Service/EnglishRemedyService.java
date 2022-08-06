package com.thapar.CropSaviour.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class EnglishRemedyService {
    public SendMessage riceDiseaseRemedy(String disease, Long chatId) {
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

                    OR CONTACT KISAN CALL CENTER (KCC) (Toll Free No.1800-180-1551)""");

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
                    1.Light traps are to be set up to attract and control the leaf hopper vectors as well as to monitor the population.
                    2.In the early morning, the population of leafhopper alighting near the light trap should be killed by spraying/dusting the insecticides.
                    3.This should be practiced every day.

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

    public SendMessage wheatDiseaseRemedy(String disease, Long chatId) {
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
}