import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradleSettingsIssueTest {
    @TempDir
    File tempDir;

    @Test
    public void test() {
        Project project = ProjectBuilder.builder().withProjectDir(tempDir).build();

        String settingsDirectory = project.getLayout().getSettingsDirectory().getAsFile().getAbsolutePath();
        String projectDirectory = project.getProjectDir().getAbsolutePath();
        String rootDirectory = project.getRootDir().getAbsolutePath();

        assertEquals(projectDirectory, rootDirectory);
        assertEquals(projectDirectory, settingsDirectory);
    }
}
