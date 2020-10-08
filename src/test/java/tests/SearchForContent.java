package tests;

import data.LoadProperties;
import org.testng.annotations.Test;
import pages.GitHubHomePage;

// this is the search for content in github with assert elements
public class SearchForContent extends TestBase {

    GitHubHomePage githubObject;

    // read values from properties file
    String searchText = LoadProperties.userData.getProperty("searchText");
    String searchElementUrlText= LoadProperties.userData.getProperty("searchElementUrl");



    // start the test for search python/cpython
    @Test(priority=1,alwaysRun=true)
    public void SearchForRepo()
    {
        githubObject = new GitHubHomePage(driver);
        githubObject.searchForContent(searchText,searchElementUrlText);
    }
}
