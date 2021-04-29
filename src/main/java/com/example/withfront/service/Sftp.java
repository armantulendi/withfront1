package com.example.withfront.service;

import com.example.withfront.config.Variables;
import com.jcraft.jsch.*;

public class Sftp {

    private static final String REMOTE_HOST = Variables.getRemoteHost();
    private static final String USERNAME = Variables.getUSERNAME();
    private static final String PASSWORD = Variables.getPASSWORD();
    private static final int REMOTE_PORT = Variables.getRemotePort();
    private static final int SESSION_TIMEOUT = 10000;
    private static final int CHANNEL_TIMEOUT = 5000;

    public static void main(String[] args) {

        Session jschSession = null;

        try {
            JSch jsch = new JSch();
            jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);
            jschSession.setConfig("StrictHostKeyChecking", "no");
            // authenticate using private key
            // jsch.addIdentity("/home/mkyong/.ssh/id_rsa");

            // authenticate using password
            jschSession.setPassword(PASSWORD);

            // 10 seconds session timeout
            jschSession.connect(SESSION_TIMEOUT);

            Channel sftp = jschSession.openChannel("sftp");

            // 5 seconds timeout
            sftp.connect(CHANNEL_TIMEOUT);

            ChannelSftp channelSftp = (ChannelSftp) sftp;

            // transfer file from local to remote server
            channelSftp.get("/var/log/kamailio.log","/home/arman");

            // download file from remote server to local
            // channelSftp.get(remoteFile, localFile);

            channelSftp.exit();

        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        } finally {
            if (jschSession != null) {
                jschSession.disconnect();
            }
        }
        System.out.println("Done");
    }

}