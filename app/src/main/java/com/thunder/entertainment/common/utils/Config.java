package com.thunder.entertainment.common.utils;

import android.os.Environment;

public class Config {
    public static final String TOKEN = "MqF35-H32j1PH8igh-am7aEkduP511g-5-F7j47Z:0gzBOkhm3KsFGbGk2HdKfA4jZp4=:eyJzY29wZSI6InNob3J0LXZpZGVvIiwiZGVhZGxpbmUiOjE2NTA3MTExMDcsInVwaG9zdHMiOlsiaHR0cDovL3VwLXoyLnFpbml1LmNvbSIsImh0dHA6Ly91cGxvYWQtejIucWluaXUuY29tIiwiLUggdXAtejIucWluaXUuY29tIGh0dHA6Ly8xODMuNjAuMjE0LjE5OCJdfQ==";
    public static final String AK = "gv8DGj6sdCLowPWx7s651Qd1QSRwpbRqgsP4DKvf";
    public static final String SK = "uD1RoVev9Zi3NoDNIxODKv4Z4qENnGG6jZx7hXsb";
    public static final String DOMAIN = "ou1zimffo.bkt.clouddn.com";

    public static final String VIDEO_STORAGE_DIR = Environment.getExternalStorageDirectory() + "/ShortVideo";
    public static final String RECORD_FILE_PATH = VIDEO_STORAGE_DIR + "/record/";
    public static final String EDITED_FILE_PATH = VIDEO_STORAGE_DIR + "/edited/";
    public static final String TRIM_FILE_PATH = VIDEO_STORAGE_DIR + "/trimmed.mp4";
    public static final String TRANSCODE_FILE_PATH = VIDEO_STORAGE_DIR + "/transcoded.mp4";
    public static final String CAPTURED_FRAME_FILE_PATH = VIDEO_STORAGE_DIR + "/captured_frame.jpg";
}
