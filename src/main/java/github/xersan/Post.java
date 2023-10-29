package github.xersan;

import java.io.Serializable;
import java.util.Date;

record Post(Date timestamp, String postString, User author) implements Serializable {}
