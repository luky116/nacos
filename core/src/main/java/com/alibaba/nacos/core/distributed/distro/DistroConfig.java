/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.nacos.core.distributed.distro;

import com.alibaba.nacos.core.config.AbstractDynamicConfig;
import com.alibaba.nacos.sys.env.EnvUtil;

/**
 * Distro configuration.
 *
 * @author xiweng.yy
 */
public class DistroConfig extends AbstractDynamicConfig {
    
    private static final String DISTRO = "Distro";
    // 单例模式下的初始化
    private static final DistroConfig INSTANCE = new DistroConfig();
    // 同步延迟时间，默认1s
    private long syncDelayMillis = DistroConstants.DEFAULT_DATA_SYNC_DELAY_MILLISECONDS;
    // 同步超时时间，默认3s
    private long syncTimeoutMillis = DistroConstants.DEFAULT_DATA_SYNC_TIMEOUT_MILLISECONDS;
    // 同步重试延迟时间，默认3s
    private long syncRetryDelayMillis = DistroConstants.DEFAULT_DATA_SYNC_RETRY_DELAY_MILLISECONDS;
    // 验证间隔时间，默认5s
    private long verifyIntervalMillis = DistroConstants.DEFAULT_DATA_VERIFY_INTERVAL_MILLISECONDS;
    // 验证超时时间，默认3s
    private long verifyTimeoutMillis = DistroConstants.DEFAULT_DATA_VERIFY_TIMEOUT_MILLISECONDS;
    // 导入数据延迟重试时间，默认30s
    private long loadDataRetryDelayMillis = DistroConstants.DEFAULT_DATA_LOAD_RETRY_DELAY_MILLISECONDS;
    // 导入超时时间，默认30s
    private long loadDataTimeoutMillis = DistroConstants.DEFAULT_DATA_LOAD_TIMEOUT_MILLISECONDS;

    private DistroConfig() {
        super(DISTRO);
        resetConfig();
    }
    
    @Override
    protected void getConfigFromEnv() {
        // 从环境变量中去读取部分配置信息
        syncDelayMillis = EnvUtil.getProperty(DistroConstants.DATA_SYNC_DELAY_MILLISECONDS, Long.class,
                DistroConstants.DEFAULT_DATA_SYNC_DELAY_MILLISECONDS);
        syncTimeoutMillis = EnvUtil.getProperty(DistroConstants.DATA_SYNC_TIMEOUT_MILLISECONDS, Long.class,
                DistroConstants.DEFAULT_DATA_SYNC_TIMEOUT_MILLISECONDS);
        syncRetryDelayMillis = EnvUtil.getProperty(DistroConstants.DATA_SYNC_RETRY_DELAY_MILLISECONDS, Long.class,
                DistroConstants.DEFAULT_DATA_SYNC_RETRY_DELAY_MILLISECONDS);
        verifyIntervalMillis = EnvUtil.getProperty(DistroConstants.DATA_VERIFY_INTERVAL_MILLISECONDS, Long.class,
                DistroConstants.DEFAULT_DATA_VERIFY_INTERVAL_MILLISECONDS);
        verifyTimeoutMillis = EnvUtil.getProperty(DistroConstants.DATA_VERIFY_TIMEOUT_MILLISECONDS, Long.class,
                DistroConstants.DEFAULT_DATA_VERIFY_TIMEOUT_MILLISECONDS);
        loadDataRetryDelayMillis = EnvUtil.getProperty(DistroConstants.DATA_LOAD_RETRY_DELAY_MILLISECONDS, Long.class,
                DistroConstants.DEFAULT_DATA_LOAD_RETRY_DELAY_MILLISECONDS);
        loadDataTimeoutMillis = EnvUtil.getProperty(DistroConstants.DATA_LOAD_TIMEOUT_MILLISECONDS, Long.class,
                DistroConstants.DEFAULT_DATA_LOAD_TIMEOUT_MILLISECONDS);
    }
    
    public static DistroConfig getInstance() {
        return INSTANCE;
    }
    
    public long getSyncDelayMillis() {
        return syncDelayMillis;
    }
    
    public void setSyncDelayMillis(long syncDelayMillis) {
        this.syncDelayMillis = syncDelayMillis;
    }
    
    public long getSyncTimeoutMillis() {
        return syncTimeoutMillis;
    }
    
    public void setSyncTimeoutMillis(long syncTimeoutMillis) {
        this.syncTimeoutMillis = syncTimeoutMillis;
    }
    
    public long getSyncRetryDelayMillis() {
        return syncRetryDelayMillis;
    }
    
    public void setSyncRetryDelayMillis(long syncRetryDelayMillis) {
        this.syncRetryDelayMillis = syncRetryDelayMillis;
    }
    
    public long getVerifyIntervalMillis() {
        return verifyIntervalMillis;
    }
    
    public void setVerifyIntervalMillis(long verifyIntervalMillis) {
        this.verifyIntervalMillis = verifyIntervalMillis;
    }
    
    public long getVerifyTimeoutMillis() {
        return verifyTimeoutMillis;
    }
    
    public void setVerifyTimeoutMillis(long verifyTimeoutMillis) {
        this.verifyTimeoutMillis = verifyTimeoutMillis;
    }
    
    public long getLoadDataRetryDelayMillis() {
        return loadDataRetryDelayMillis;
    }
    
    public void setLoadDataRetryDelayMillis(long loadDataRetryDelayMillis) {
        this.loadDataRetryDelayMillis = loadDataRetryDelayMillis;
    }
    
    public long getLoadDataTimeoutMillis() {
        return loadDataTimeoutMillis;
    }
    
    public void setLoadDataTimeoutMillis(long loadDataTimeoutMillis) {
        this.loadDataTimeoutMillis = loadDataTimeoutMillis;
    }
    
    @Override
    protected String printConfig() {
        return "DistroConfig{" + "syncDelayMillis=" + syncDelayMillis + ", syncTimeoutMillis=" + syncTimeoutMillis
                + ", syncRetryDelayMillis=" + syncRetryDelayMillis + ", verifyIntervalMillis=" + verifyIntervalMillis
                + ", verifyTimeoutMillis=" + verifyTimeoutMillis + ", loadDataRetryDelayMillis="
                + loadDataRetryDelayMillis + '}';
    }
}
