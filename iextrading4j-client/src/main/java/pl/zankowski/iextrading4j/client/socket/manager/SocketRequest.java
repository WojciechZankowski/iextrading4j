package pl.zankowski.iextrading4j.client.socket.manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class SocketRequest<R> {

    private final TypeReference<R> responseType;
    private final String path;
    private final Object param;

    public SocketRequest(final TypeReference<R> responseType, final String path, final Object param) {
        this.responseType = responseType;
        this.path = path;
        this.param = param;
    }

    public TypeReference<R> getResponseType() {
        return responseType;
    }

    public String getPath() {
        return path;
    }

    public Object getParam() {
        return param;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocketRequest<?> that = (SocketRequest<?>) o;
        return Objects.equal(responseType, that.responseType) &&
                Objects.equal(path, that.path) &&
                Objects.equal(param, that.param);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(responseType, path, param);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("responseType", responseType)
                .add("path", path)
                .add("param", param)
                .toString();
    }
}
