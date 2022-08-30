package com.thetheu.ftpclient

import org.apache.commons.net.PrintCommandListener
import org.apache.commons.net.ftp.FTPClient
import org.apache.commons.net.ftp.FTPReply
import java.io.IOException
import java.io.PrintWriter

class FtpClient {
    private val server = ""
    private val port = 0
    private val user = ""
    private val pass = ""
    private val ftp = FTPClient()


    fun open() {
        ftp.addProtocolCommandListener(PrintCommandListener(PrintWriter(System.out)))
        ftp.connect(server, port)
        val reply = ftp.replyCode
        if (!FTPReply.isPositiveCompletion(reply)){
            ftp.disconnect()
            throw IOException("Deu merda aqui")
        }
        ftp.login(user, pass)
    }
    fun close(){
        ftp.disconnect()
    }

}