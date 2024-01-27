package lesson10.testGoogleTranslate;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestGoogleTranslate {
    @BeforeMethod
    public void beforeMethod() {
        Configuration.baseUrl = "https://translate.google.com/";
        Configuration.browser = "firefox";
    }

    @Test(dataProvider = "expectedResult")
    public void TranslateTest(String lang, String name) {
        String actualResult = null;
        try {
            open("?sl=uk&tl=" + lang + "&text=Я%20круто%20вивчу%20TestNG&op=translate");
            String translation = actualResult = $(".lRu31").shouldHave().text();
            Assert.assertEquals(translation,name," ");
        } catch (Throwable exception) {
            System.out.println("Actual result: " + actualResult + "\n" + "isn't equal to expected result: " + name);
        }
//
    }

    @DataProvider(name = "expectedResult")
    public Object[][] expectedResult() {
        return new Object[][]{
                {"en", "I will study TESTNG cool"},
                {"af", "Ek sal toets cool bestudeer"},
                {"sq", "Unë do të studioj testng të freskëta"},
                {"am", "እኔ ቀዝቃዛ አሪፍ አጠናለሁ"},
                {"ar", "سأدرس testng بارد"},
                {"hy", "Ես կսովորեմ TestNG cool"},
                {"as", "মই TestNG শিকিম শীতল"},
                {"iw", "אני אלמד TestNG מגניב"},
                {"kri", "A go lan TestNG kul"},
                {"pt", "Vou aprender TestNG legal"},
                {"lb", "Ech wäert TestNG cool léieren"},
                {"mi", "Ka ako ahau TestNG hauhautanga"},
                {"ny", "Ndiphunzira TestNG ozizira"},
                {"lv", "Es iemācīšos TestNG forši"},
                {"lg", "Nja kuyiga TestNG cool"},
                {"zh-CN", "我会学习 TestNG 很酷"},
                {"jw", "Aku bakal sinau TestNG kelangan"},
                {"et", "Ma õpin TestNG lahedaks"},
                {"ja", "TestNGをかっこよく学びます"},
                {"pl", "Nauczę się TestNG cool"},
        };
    }
}
