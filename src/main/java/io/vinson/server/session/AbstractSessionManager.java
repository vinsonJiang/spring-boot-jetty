package io.vinson.server.session;

/**
 * @author: jiangweixin
 * @date: 2019/8/23
 */
public class AbstractSessionManager {
    protected void doStart() throws Exception {

    }

    protected void doStop() throws Exception {

    }

    protected void addSession(AbstractSession session) {

    }

    protected void removeSession(AbstractSession sess, boolean invalidate) {

    }

    protected boolean removeSession(String clusterId) {
        return false;
    }

    protected SessionManagerSkeleton.SessionSkeleton getSession(String clusterId) {
        return null;
    }
}
