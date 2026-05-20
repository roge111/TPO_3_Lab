import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='/privacy-policy/']")
    @CacheLookup
    private WebElement ;

    @FindBy(css = "a[href='/enciklopediya/']")
    @CacheLookup
    private WebElement _1;

    @FindBy(css = "button.style-module-scss-module__Aee_7q__button._5av9lj._hwbjan._1l9gohj")
    @CacheLookup
    private WebElement _1;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) a:nth-of-type(1) div._10cf6rv._a5x2hz div:nth-of-type(1) a.style-module-scss-module__xVTBhW__link.style-module-scss-module___5I0Dq__link")
    @CacheLookup
    private WebElement _1;

    @FindBy(css = "a[href='/stat/futbol/tournament/667/']")
    @CacheLookup
    private WebElement _1;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(6) div:nth-of-type(2) a:nth-of-type(2)")
    @CacheLookup
    private WebElement _10;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(6) div:nth-of-type(1) button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _10;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(7) div.style-module-scss-module__G4E93a__row button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _11;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(4) div.style-module-scss-module__MRzuLG__card._10cf6rv._19sgipd div:nth-of-type(2) div:nth-of-type(6) div.style-module-scss-module__Z2HzoW__container a.style-module-scss-module__vuCcda__link")
    @CacheLookup
    private WebElement _11;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(3) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(1)")
    @CacheLookup
    private WebElement _11325;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(1)")
    @CacheLookup
    private WebElement _1193;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(8) div:nth-of-type(1) button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _12;

    @FindBy(css = "a[href='/bukmekery/s-minimalnym-depozitom/']")
    @CacheLookup
    private WebElement _12;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(6) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(1)")
    @CacheLookup
    private WebElement _1205;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(4) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(1)")
    @CacheLookup
    private WebElement _1231;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(9) div:nth-of-type(1) button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _13;

    @FindBy(css = "a[href='/bukmekery/bonusy-dlya-novyh-igrokov/']")
    @CacheLookup
    private WebElement _13;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(10) div:nth-of-type(1) button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _14;

    @FindBy(css = "a[href='/bukmekery/bonus-na-pervyj-depozit/']")
    @CacheLookup
    private WebElement _14;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(1)")
    @CacheLookup
    private WebElement _145;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(11) div:nth-of-type(1) button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _15;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(5) div.style-module-scss-module__Y88kRa__prefooter div:nth-of-type(8) div.style-module-scss-module__Y88kRa__prefooterItemContent a:nth-of-type(1)")
    @CacheLookup
    private WebElement _15;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) a:nth-of-type(1)")
    @CacheLookup
    private WebElement _1522;

    @FindBy(css = "a[href='/bukmekery/luchshie/']")
    @CacheLookup
    private WebElement _16;

    @FindBy(css = "a[href='/prognozy/football/']")
    @CacheLookup
    private WebElement _16;

    @FindBy(css = "a[href='/bukmekery/rejting-nadezhnosti/']")
    @CacheLookup
    private WebElement _17;

    @FindBy(css = "a[href='/prognozy/tennis/']")
    @CacheLookup
    private WebElement _17;

    @FindBy(css = "a[href='/bukmekery/luchshie-fribety/']")
    @CacheLookup
    private WebElement _18;

    @FindBy(css = "a[href='/prognozy/basketball/']")
    @CacheLookup
    private WebElement _18;

    @FindBy(css = "a[href='/bukmekery/bezdepozitnye-bonusy/']")
    @CacheLookup
    private WebElement _19;

    @FindBy(css = "a[href='/prognozy/hockey/']")
    @CacheLookup
    private WebElement _19;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) a:nth-of-type(2)")
    @CacheLookup
    private WebElement _2;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(5) div:nth-of-type(2) div.style-module-scss-module__mQ0c2G__wrapper.style-module-scss-module__mQ0c2G__stretch._10cf6rv._1sw1upg._1d6xnj._1pa7vqy button._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _2;

    @FindBy(css = "a[href='/stat/futbol/tournament/144/']")
    @CacheLookup
    private WebElement _2;

    @FindBy(css = "a.style-module-scss-module__vuCcda__link.style-module-scss-module__MRzuLG__primaryNews")
    @CacheLookup
    private WebElement _2;

    @FindBy(css = "a[href='/bukmekery/dlya-mobilnogo/']")
    @CacheLookup
    private WebElement _20;

    @FindBy(css = "a[href='/prognozy/cybersport/']")
    @CacheLookup
    private WebElement _20;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(6) div:nth-of-type(2) a:nth-of-type(1)")
    @CacheLookup
    private WebElement _21;

    @FindBy(css = "a[href='/bukmekery/na-android/']")
    @CacheLookup
    private WebElement _21;

    @FindBy(css = "a[href='/prognozy/mma/']")
    @CacheLookup
    private WebElement _21;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(3) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(3)")
    @CacheLookup
    private WebElement _212;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(3)")
    @CacheLookup
    private WebElement _2178;

    @FindBy(css = "a[href='/bukmekery/na-ajfon/']")
    @CacheLookup
    private WebElement _22;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(4) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(3)")
    @CacheLookup
    private WebElement _2278;

    @FindBy(css = "a[href='/bukmekery/stavki-na-vodnoe-polo/']")
    @CacheLookup
    private WebElement _23;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(6) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(3)")
    @CacheLookup
    private WebElement _2366;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(3)")
    @CacheLookup
    private WebElement _2395;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(5) div.style-module-scss-module__Y88kRa__prefooter div:nth-of-type(4) a._i91ye._qagut5")
    @CacheLookup
    private WebElement _24;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(5) div.style-module-scss-module__Y88kRa__prefooter div:nth-of-type(5) a._i91ye._qagut5")
    @CacheLookup
    private WebElement _25;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(5) div.style-module-scss-module__Y88kRa__prefooter div:nth-of-type(6) div.style-module-scss-module__Y88kRa__prefooterItemContent a:nth-of-type(1)")
    @CacheLookup
    private WebElement _26;

    @FindBy(css = "a[href='/stat/football/yesterday/']")
    @CacheLookup
    private WebElement _27;

    @FindBy(css = "a[href='/stat/football/tomorrow/']")
    @CacheLookup
    private WebElement _28;

    @FindBy(css = "a[href='/stat/tennis/']")
    @CacheLookup
    private WebElement _29;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) a:nth-of-type(1) div._10cf6rv._a5x2hz div:nth-of-type(1) a.style-module-scss-module__xVTBhW__link.style-module-scss-module___5I0Dq__link")
    @CacheLookup
    private WebElement _3;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) a.style-module-scss-module__vuCcda__link")
    @CacheLookup
    private WebElement _3;

    @FindBy(css = "a[href='/mag/novosti/sperczyan-krasnodar-gotov-pobezhdat-v-superfinale-kubka-rossii/']")
    @CacheLookup
    private WebElement _3;

    @FindBy(css = "a[href='/stat/tennis/yesterday/']")
    @CacheLookup
    private WebElement _30;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) a:nth-of-type(1)")
    @CacheLookup
    private WebElement _3021;

    @FindBy(css = "a[href='/stat/tennis/tomorrow/']")
    @CacheLookup
    private WebElement _31;

    @FindBy(css = "a[href='/stat/hockey/']")
    @CacheLookup
    private WebElement _32;

    @FindBy(css = "a[href='/stat/hockey/yesterday/']")
    @CacheLookup
    private WebElement _33;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(5) div.style-module-scss-module__Y88kRa__prefooter div:nth-of-type(6) a._i91ye._qagut5")
    @CacheLookup
    private WebElement _34;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(5) div.style-module-scss-module__Y88kRa__prefooter div:nth-of-type(7) div.style-module-scss-module__Y88kRa__prefooterItemContent a:nth-of-type(1)")
    @CacheLookup
    private WebElement _35;

    @FindBy(css = "a[href='/mag/novosti/football/']")
    @CacheLookup
    private WebElement _36;

    @FindBy(css = "a[href='/mag/novosti/tennis/']")
    @CacheLookup
    private WebElement _37;

    @FindBy(css = "a[href='/mag/novosti/basketball/']")
    @CacheLookup
    private WebElement _38;

    @FindBy(css = "a[href='/mag/novosti/hockey/']")
    @CacheLookup
    private WebElement _39;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) a:nth-of-type(2)")
    @CacheLookup
    private WebElement _4;

    @FindBy(css = "button.style-module-scss-module__m0vlOG__allGamesButton._5av9lj._v1o17a._1l9gohj")
    @CacheLookup
    private WebElement _4;

    @FindBy(css = "a[href='/mag/novosti/zhoao-pedro-priznan-luchshim-igrokom-sezona-v-chelsi/']")
    @CacheLookup
    private WebElement _4;

    @FindBy(css = "a[href='/mag/novosti/cybersport/']")
    @CacheLookup
    private WebElement _40;

    @FindBy(css = "a[href='/mag/novosti/mma/']")
    @CacheLookup
    private WebElement _41;

    @FindBy(css = "a[href='/melbet/']")
    @CacheLookup
    private WebElement _411;

    @FindBy(css = "a[href='/baltbet/']")
    @CacheLookup
    private WebElement _414;

    @FindBy(css = "a[href='/stat/hockey/tournament/5092/']")
    @CacheLookup
    private WebElement _42;

    @FindBy(css = "a[href='/liga-stavok/']")
    @CacheLookup
    private WebElement _422;

    @FindBy(css = "a[href='/bet-m/']")
    @CacheLookup
    private WebElement _43;

    @FindBy(css = "a[href='/stat/football/tournament/17/']")
    @CacheLookup
    private WebElement _43;

    @FindBy(css = "a[href='/stat/football/tournament/11/']")
    @CacheLookup
    private WebElement _44;

    @FindBy(css = "a[href='/zenit/']")
    @CacheLookup
    private WebElement _447;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(5) div.style-module-scss-module__Y88kRa__prefooter div:nth-of-type(9) a._i91ye._qagut5")
    @CacheLookup
    private WebElement _45;

    @FindBy(css = "a[href='/polzovatelskoe-soglashenie']")
    @CacheLookup
    private WebElement _46;

    @FindBy(css = "a[href='/winline/']")
    @CacheLookup
    private WebElement _462;

    @FindBy(css = "a[href='/privacy-policy']")
    @CacheLookup
    private WebElement _47;

    @FindBy(css = "a[href='/leon/']")
    @CacheLookup
    private WebElement _471;

    @FindBy(css = "a[href='/karta-sajta']")
    @CacheLookup
    private WebElement _48;

    @FindBy(css = "a[href='/marafon/']")
    @CacheLookup
    private WebElement _482;

    @FindBy(css = "a[href='/betboom/']")
    @CacheLookup
    private WebElement _49;

    @FindBy(css = "a[href='/otvetstvennaya-igra']")
    @CacheLookup
    private WebElement _49;

    @FindBy(css = "a[href='/fonbet/']")
    @CacheLookup
    private WebElement _492;

    @FindBy(css = "a[href='/pari/']")
    @CacheLookup
    private WebElement _497;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(3) div:nth-of-type(2) a:nth-of-type(1) div._10cf6rv._a5x2hz div:nth-of-type(1) a.style-module-scss-module__xVTBhW__link.style-module-scss-module___5I0Dq__link")
    @CacheLookup
    private WebElement _5;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(1) div:nth-of-type(1) button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _5;

    @FindBy(css = "a[href='/mag/novosti/zhanibek-alimhanuly-planiruet-vernutsya-na-ring-v-dekabre-2026-goda/']")
    @CacheLookup
    private WebElement _5;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(3) div:nth-of-type(2) a:nth-of-type(2)")
    @CacheLookup
    private WebElement _6;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(2) div:nth-of-type(1) button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _6;

    @FindBy(css = "a[href='/mag/novosti/degtyarev-otmetil-vklad-uchitelej-fizkultury-v-uspehi-rossijskih-sportsmenov/']")
    @CacheLookup
    private WebElement _6;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(4) div:nth-of-type(2) a:nth-of-type(1) div._10cf6rv._a5x2hz div:nth-of-type(1) a.style-module-scss-module__xVTBhW__link.style-module-scss-module___5I0Dq__link")
    @CacheLookup
    private WebElement _7;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(3) div:nth-of-type(1) button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _7;

    @FindBy(css = "a[href='/mag/novosti/filip-gustavsson-iz-minnesoty-pereneset-operacziyu-na-bedre/']")
    @CacheLookup
    private WebElement _7;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(4) div:nth-of-type(2) a:nth-of-type(2)")
    @CacheLookup
    private WebElement _8;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(4) div:nth-of-type(1) button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _8;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(5) div:nth-of-type(2) a:nth-of-type(2)")
    @CacheLookup
    private WebElement _9;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(3) div.style-module-scss-module__4sM0ua__list span:nth-of-type(5) div:nth-of-type(1) button.style-module-scss-module__G4E93a__advertButton._5av9lj._v1o17a._17fdcj3")
    @CacheLookup
    private WebElement _9;

    @FindBy(css = "a[href='/bukmekery/stavki-na-arena-of-valor/']")
    @CacheLookup
    private WebElement arenaOfValor;

    @FindBy(css = "a[href='/bukmekery/stavki-na-call-of-duty/']")
    @CacheLookup
    private WebElement callOfDuty;

    @FindBy(css = "a[href='/bukmekery/stavki-na-counter-strike-2/']")
    @CacheLookup
    private WebElement counterstrike2;

    @FindBy(css = "a[href='/bukmekery/stavki-na-counter-strike-2-duels/']")
    @CacheLookup
    private WebElement counterstrike2Duels;

    @FindBy(css = "a[href='/bukmekery/stavki-na-dota2/']")
    @CacheLookup
    private WebElement dota2;

    @FindBy(css = "a[href='/bukmekery/stavki-na-ebasketball/']")
    @CacheLookup
    private WebElement ebasketball;

    @FindBy(css = "a[href='/bukmekery/stavki-na-efootball/']")
    @CacheLookup
    private WebElement efootball;

    @FindBy(css = "a[href='https://sravni.bet']")
    @CacheLookup
    private WebElement httpssravniBet;

    @FindBy(css = "a[href='/bukmekery/stavki-na-king-of-glory/']")
    @CacheLookup
    private WebElement kingOfGlory;

    @FindBy(css = "a[href='/bukmekery/s-live-stavkami/']")
    @CacheLookup
    private WebElement live;

    private final String pageLoadedText = "Телефон: + 7 926 321 02 88";

    private final String pageUrl = "/";

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(5) div:nth-of-type(2) a:nth-of-type(1)")
    @CacheLookup
    private WebElement rwFrankfurt19;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(3) div:nth-of-type(2) a:nth-of-type(1)")
    @CacheLookup
    private WebElement u2002;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(4) div:nth-of-type(2) a:nth-of-type(1)")
    @CacheLookup
    private WebElement u2015;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(4) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(2)")
    @CacheLookup
    private WebElement x332;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(6) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(2)")
    @CacheLookup
    private WebElement x375;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(2)")
    @CacheLookup
    private WebElement x385;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(2)")
    @CacheLookup
    private WebElement x44;

    @FindBy(css = ".style-module-scss-module__6mMROa__body div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(3) div:nth-of-type(2) div._10cf6rv._1sw1upg._1d6xnj._15f0z2h button:nth-of-type(2)")
    @CacheLookup
    private WebElement x54;

    public MainPage() {
    }

    public MainPage(WebDriver driver) {
        this();
        this.driver = driver;
    }

    public MainPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public MainPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on 22 15 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage click15Link22() {
        _1522.click();
        return this;
    }

    /**
     * Click on 21 30 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage click30Link21() {
        _3021.click();
        return this;
    }

    /**
     * Click on Arena Of Valor Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickArenaOfValorLink() {
        arenaOfValor.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton1() {
        _1.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton10() {
        _10.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton11() {
        _11.click();
        return this;
    }

    /**
     * Click on 113.25 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton11325() {
        _11325.click();
        return this;
    }

    /**
     * Click on 11.93 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton1193() {
        _1193.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton12() {
        _12.click();
        return this;
    }

    /**
     * Click on 12.05 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton1205() {
        _1205.click();
        return this;
    }

    /**
     * Click on 12.31 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton1231() {
        _1231.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton13() {
        _13.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton14() {
        _14.click();
        return this;
    }

    /**
     * Click on 14.5 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton145() {
        _145.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton15() {
        _15.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton2() {
        _2.click();
        return this;
    }

    /**
     * Click on 21.2 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton212() {
        _212.click();
        return this;
    }

    /**
     * Click on 21.78 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton2178() {
        _2178.click();
        return this;
    }

    /**
     * Click on 22.78 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton2278() {
        _2278.click();
        return this;
    }

    /**
     * Click on 23.66 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton2366() {
        _2366.click();
        return this;
    }

    /**
     * Click on 23.95 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton2395() {
        _2395.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton4() {
        _4.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton5() {
        _5.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton6() {
        _6.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton7() {
        _7.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton8() {
        _8.click();
        return this;
    }

    /**
     * Click on  Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickButton9() {
        _9.click();
        return this;
    }

    /**
     * Click on Call Of Duty Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickCallOfDutyLink() {
        callOfDuty.click();
        return this;
    }

    /**
     * Click on Counterstrike 2 Duels Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickCounterstrike2DuelsLink() {
        counterstrike2Duels.click();
        return this;
    }

    /**
     * Click on Counterstrike 2 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickCounterstrike2Link() {
        counterstrike2.click();
        return this;
    }

    /**
     * Click on Dota 2 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickDota2Link() {
        dota2.click();
        return this;
    }

    /**
     * Click on Ebasketball Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickEbasketballLink() {
        ebasketball.click();
        return this;
    }

    /**
     * Click on Efootball Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickEfootballLink() {
        efootball.click();
        return this;
    }

    /**
     * Click on Httpssravni.bet Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickHttpssravniBetLink() {
        httpssravniBet.click();
        return this;
    }

    /**
     * Click on King Of Glory Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickKingOfGloryLink() {
        kingOfGlory.click();
        return this;
    }

    /**
     * Click on . Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink() {
        .click();
        return this;
    }

    /**
     * Click on 21 ... Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink1() {
        _1.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink1() {
        _1.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink1() {
        _1.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink10() {
        _10.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink11() {
        _11.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink12() {
        _12.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink13() {
        _13.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink14() {
        _14.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink15() {
        _15.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink16() {
        _16.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink16() {
        _16.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink17() {
        _17.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink17() {
        _17.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink18() {
        _18.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink18() {
        _18.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink19() {
        _19.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink19() {
        _19.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink2() {
        _2.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink2() {
        _2.click();
        return this;
    }

    /**
     * Click on 21 ... Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink2() {
        _2.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink20() {
        _20.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink20() {
        _20.click();
        return this;
    }

    /**
     * Click on 21 30 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink21() {
        _21.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink21() {
        _21.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink21() {
        _21.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink22() {
        _22.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink23() {
        _23.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink24() {
        _24.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink25() {
        _25.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink26() {
        _26.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink27() {
        _27.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink28() {
        _28.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink29() {
        _29.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink3() {
        _3.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink3() {
        _3.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink3() {
        _3.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink30() {
        _30.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink31() {
        _31.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink32() {
        _32.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink33() {
        _33.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink34() {
        _34.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink35() {
        _35.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink36() {
        _36.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink37() {
        _37.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink38() {
        _38.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink39() {
        _39.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink4() {
        _4.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink4() {
        _4.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink40() {
        _40.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink41() {
        _41.click();
        return this;
    }

    /**
     * Click on 4.11 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink411() {
        _411.click();
        return this;
    }

    /**
     * Click on 4.14 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink414() {
        _414.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink42() {
        _42.click();
        return this;
    }

    /**
     * Click on 4.22 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink422() {
        _422.click();
        return this;
    }

    /**
     * Click on 4.3 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink43() {
        _43.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink43() {
        _43.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink44() {
        _44.click();
        return this;
    }

    /**
     * Click on 4.47 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink447() {
        _447.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink45() {
        _45.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink46() {
        _46.click();
        return this;
    }

    /**
     * Click on 4.62 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink462() {
        _462.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink47() {
        _47.click();
        return this;
    }

    /**
     * Click on 4.71 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink471() {
        _471.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink48() {
        _48.click();
        return this;
    }

    /**
     * Click on 4.82 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink482() {
        _482.click();
        return this;
    }

    /**
     * Click on 4.9 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink49() {
        _49.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink49() {
        _49.click();
        return this;
    }

    /**
     * Click on 4.92 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink492() {
        _492.click();
        return this;
    }

    /**
     * Click on 4.97 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink497() {
        _497.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink5() {
        _5.click();
        return this;
    }

    /**
     * Click on 2026 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink5() {
        _5.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink6() {
        _6.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink6() {
        _6.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink7() {
        _7.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink7() {
        _7.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink8() {
        _8.click();
        return this;
    }

    /**
     * Click on  Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLink9() {
        _9.click();
        return this;
    }

    /**
     * Click on Live Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickLiveLink() {
        live.click();
        return this;
    }

    /**
     * Click on Rw Frankfurt 19 30 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickRwFrankfurt19Link() {
        rwFrankfurt19.click();
        return this;
    }

    /**
     * Click on U200 2 U20 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickU2002Link() {
        u2002.click();
        return this;
    }

    /**
     * Click on U20 15 00 U20 Link.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickU2015Link() {
        u2015.click();
        return this;
    }

    /**
     * Click on X3.32 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickX332Button() {
        x332.click();
        return this;
    }

    /**
     * Click on X3.75 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickX375Button() {
        x375.click();
        return this;
    }

    /**
     * Click on X3.85 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickX385Button() {
        x385.click();
        return this;
    }

    /**
     * Click on X4.4 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickX44Button() {
        x44.click();
        return this;
    }

    /**
     * Click on X5.4 Button.
     *
     * @return the MainPage class instance.
     */
    public MainPage clickX54Button() {
        x54.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the MainPage class instance.
     */
    public MainPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the MainPage class instance.
     */
    public MainPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
