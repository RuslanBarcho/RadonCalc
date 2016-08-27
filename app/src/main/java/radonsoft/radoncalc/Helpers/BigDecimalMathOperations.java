package radonsoft.radoncalc.Helpers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.security.* ;
import java.util.* ;
import java.math.* ;

/**
 * Created by Ruska on 19.07.2016.
 */
public class BigDecimalMathOperations {
    static BigDecimal E = new BigDecimal("2.71828182845904523536028747135266249775724709369995957496696762772407663035354"+
            "759457138217852516642742746639193200305992181741359662904357290033429526059563"+
            "073813232862794349076323382988075319525101901157383418793070215408914993488416"+
            "750924476146066808226480016847741185374234544243710753907774499206955170276183"+
            "860626133138458300075204493382656029760673711320070932870912744374704723069697"+
            "720931014169283681902551510865746377211125238978442505695369677078544996996794"+
            "686445490598793163688923009879312773617821542499922957635148220826989519366803"+
            "318252886939849646510582093923982948879332036250944311730123819706841614039701"+
            "983767932068328237646480429531180232878250981945581530175671736133206981125099"+
            "618188159304169035159888851934580727386673858942287922849989208680582574927961"+
            "048419844436346324496848756023362482704197862320900216099023530436994184914631"+
            "409343173814364054625315209618369088870701676839642437814059271456354906130310"+
            "720851038375051011574770417189861068739696552126715468895703503540212340784981"+
            "933432106817012100562788023519303322474501585390473041995777709350366041699732"+
            "972508868769664035557071622684471625607988265178713419512466520103059212366771"+
            "943252786753985589448969709640975459185695638023637016211204774272283648961342"+
            "251644507818244235294863637214174023889344124796357437026375529444833799801612"+
            "549227850925778256209262264832627793338656648162772516401910590049164499828931") ;

    /** Euler's constant Pi.
     * http://www.cs.arizona.edu/icon/oddsends/pi.htm
     */
    static BigDecimal PI = new BigDecimal("3.14159265358979323846264338327950288419716939937510582097494459230781640628620"+
            "899862803482534211706798214808651328230664709384460955058223172535940812848111"+
            "745028410270193852110555964462294895493038196442881097566593344612847564823378"+
            "678316527120190914564856692346034861045432664821339360726024914127372458700660"+
            "631558817488152092096282925409171536436789259036001133053054882046652138414695"+
            "194151160943305727036575959195309218611738193261179310511854807446237996274956"+
            "735188575272489122793818301194912983367336244065664308602139494639522473719070"+
            "217986094370277053921717629317675238467481846766940513200056812714526356082778"+
            "577134275778960917363717872146844090122495343014654958537105079227968925892354"+
            "201995611212902196086403441815981362977477130996051870721134999999837297804995"+
            "105973173281609631859502445945534690830264252230825334468503526193118817101000"+
            "313783875288658753320838142061717766914730359825349042875546873115956286388235"+
            "378759375195778185778053217122680661300192787661119590921642019893809525720106"+
            "548586327886593615338182796823030195203530185296899577362259941389124972177528"+
            "347913151557485724245415069595082953311686172785588907509838175463746493931925"+
            "506040092770167113900984882401285836160356370766010471018194295559619894676783"+
            "744944825537977472684710404753464620804668425906949129331367702898915210475216"+
            "205696602405803815019351125338243003558764024749647326391419927260426992279678"+
            "235478163600934172164121992458631503028618297455570674983850549458858692699569"+
            "092721079750930295532116534498720275596023648066549911988183479775356636980742"+
            "654252786255181841757467289097777279380008164706001614524919217321721477235014") ;

    public static BigDecimal sin(final BigDecimal x, String radians){
        double xd = x.doubleValue();
        if (radians.equals("DEG")){
            if ((xd/180)%1 == 0){
                xd = 0;
            }
            else{
                xd = Math.sin(Math.toRadians(xd));
            }
        }
        else {
            xd = Math.sin(xd);
        }
        BigDecimal xdx = new BigDecimal(xd);
        return xdx;
    }

    public static BigDecimal cos(final BigDecimal x, String radians){
        double xd = x.doubleValue();
        if (radians.equals("DEG")){
            xd = Math.cos(Math.toRadians(xd));
        }
        else {
            xd = Math.cos(xd);
        }
        BigDecimal xdx = new BigDecimal(xd);
        return xdx;
    }

    public static BigDecimal tan(final BigDecimal x, String radians){
        double xd = x.doubleValue();
        if (radians.equals("DEG")){
            xd = Math.tan(Math.toRadians(xd));
        }
        else {
            xd = Math.tan(xd);
        }
        BigDecimal xdx = new BigDecimal(xd);
        return xdx;
    }

}
