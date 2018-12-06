package com.vulpelo;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ServerConnection {

    public void getCurrencyCollectionData(String urlPath, String filePath) throws Exception{
        // downloading files
        FileOutputStream file;

        URL website = new URL(urlPath);
        ReadableByteChannel rBC = Channels.newChannel(website.openStream());
        file = new FileOutputStream(filePath);
        file.getChannel().transferFrom(rBC, 0, Long.MAX_VALUE);
        file.close();
    }
}
