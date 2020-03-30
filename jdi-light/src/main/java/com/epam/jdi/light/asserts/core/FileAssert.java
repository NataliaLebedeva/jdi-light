package com.epam.jdi.light.asserts.core;

import com.epam.jdi.light.asserts.generic.BaseAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import org.hamcrest.Matcher;

import java.io.File;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.PathUtils.*;
import static java.util.Objects.*;
import static org.apache.commons.io.FileUtils.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class FileAssert extends BaseAssert<IBaseElement> {
    public static FileAssert assertThatFile(String fileName) {
        return new FileAssert(fileName);
    }
    private File file;

    public FileAssert(String fileName) {
        super(fileName);
        file = new File(mergePath(DRIVER.downloadsFolder, fileName));
    }
    /**
     * Check that file is downloaded
     * @return FileAssert
     */
    @JDIAction("Assert that file '{name}' is downloaded")
    public FileAssert isDownloaded() {
        assertThat(file.exists(), is(true));
        return this;
    }

    /**
     * Match passed value with file text
     * @param text to compare
     * @return FileAssert
     */
    @JDIAction("Assert that file '{name}' text {0}")
    public FileAssert text(Matcher<String> text) {
        try {
            assertThat(readFileToString(file, "UTF-8"), text);
            return this;
        } catch (Exception ex) {
            throw exception(ex, "Error reading file");
        }
    }
    public FileAssert text(String text) { return text(is(text)); }

    /**
     * Match passed value with file size
     * @param size to compare
     * @return FileAssert
     */
    @JDIAction("Assert file '{name}' size")
    public FileAssert hasSize(Matcher<Long> size) {
        assertThat(file.length(), size);
        return this;
    }
    /**
     * Match passed value with file size
     * @param min, max to compare
     * @return FileAssert
     */
    @JDIAction("Assert file '{name}' size")
    public FileAssert hasSize(long min, long max) {
        long fileSize = file.length();
        assertThat(fileSize, greaterThan(min));
        assertThat(fileSize, lessThan(max));
        return this;
    }
    public FileAssert hasSize(long size) {
        return hasSize(size-10, size+10);
    }
    public static void cleanupDownloads() {
        File dir = new File(DRIVER.downloadsFolder);
        for(File file : requireNonNull(dir.listFiles()))
            file.delete();
        logger.info("Remove all downloads successfully");
    }
}
