/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.pool2.impl;

/**
 * Provides the implementation for the common attributes shared by the
 * sub-classes. New instances of this class will be created using the defaults
 * defined by the public constants.
 * <p>
 * This class is not thread-safe.
 */
public abstract class BaseObjectPoolConfig implements Cloneable {

    /**
     * The default value for the {@code lifo} configuration attribute.
     * @see GenericObjectPool#getLifo()
     * @see GenericKeyedObjectPool#getLifo()
     */
    public static final boolean DEFAULT_LIFO = true;

    /**
     * The default value for the {@code maxWait} configuration attribute.
     * @see GenericObjectPool#getMaxWait()
     * @see GenericKeyedObjectPool#getMaxWait()
     */
    public static final long DEFAULT_MAX_WAIT = -1L;

    /**
     * The default value for the {@code minEvictableIdleTimeMillis}
     * configuration attribute.
     * @see GenericObjectPool#getMinEvictableIdleTimeMillis()
     * @see GenericKeyedObjectPool#getMinEvictableIdleTimeMillis()
     */
    public static final long DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS =
            1000L * 60L * 30L;

    /**
     * The default value for the {@code softMinEvictableIdleTimeMillis}
     * configuration attribute.
     * @see GenericObjectPool#getSoftMinEvictableIdleTimeMillis()
     * @see GenericKeyedObjectPool#getSoftMinEvictableIdleTimeMillis()
     */
    public static final long DEFAULT_SOFT_MIN_EVICTABLE_IDLE_TIME_MILLIS = -1;

    /**
     * The default value for the {@code numTestsPerEvictionRun} configuration
     * attribute.
     * @see GenericObjectPool#getNumTestsPerEvictionRun()
     * @see GenericKeyedObjectPool#getNumTestsPerEvictionRun()
     */
    public static final int DEFAULT_NUM_TESTS_PER_EVICTION_RUN = 3;

    /**
     * The default value for the {@code testOnBorrow} configuration attribute.
     * @see GenericObjectPool#getTestOnBorrow()
     * @see GenericKeyedObjectPool#getTestOnBorrow()
     */
    public static final boolean DEFAULT_TEST_ON_BORROW = false;

    /**
     * The default value for the {@code testOnReturn} configuration attribute.
     * @see GenericObjectPool#getTestOnReturn()
     * @see GenericKeyedObjectPool#getTestOnReturn()
     */
    public static final boolean DEFAULT_TEST_ON_RETURN = false;

    /**
     * The default value for the {@code testWhileIdle} configuration attribute.
     * @see GenericObjectPool#getTestWhileIdle()
     * @see GenericKeyedObjectPool#getTestWhileIdle()
     */
    public static final boolean DEFAULT_TEST_WHILE_IDLE = false;

    /**
     * The default value for the {@code timeBetweenEvictionRunsMillis}
     * configuration attribute.
     * @see GenericObjectPool#getTimeBetweenEvictionRunsMillis()
     * @see GenericKeyedObjectPool#getTimeBetweenEvictionRunsMillis()
     */
    public static final long DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS = -1L;

    /**
     * The default value for the {@code blockWhenExhausted} configuration
     * attribute.
     * @see GenericObjectPool#getBlockWhenExhausted()
     * @see GenericKeyedObjectPool#getBlockWhenExhausted()
     */
    public static final boolean DEFAULT_BLOCK_WHEN_EXHAUSTED = true;

    /**
     * The default value for enabling JMX for pools created with a configuration
     * instance.
     */
    public static final boolean DEFAULT_JMX_ENABLE = true;

    /**
     * The default value for the prefix used to name JMX enabled pools created
     * with a configuration instance.
     * @see GenericObjectPool#getJmxName()
     * @see GenericKeyedObjectPool#getJmxName()
     */
    public static final String DEFAULT_JMX_NAME_PREFIX = "pool";

    /**
     * The default value for the {@code evictionPolicyClassName} configuration
     * attribute.
     * @see GenericObjectPool#getEvictionPolicyClassName()
     * @see GenericKeyedObjectPool#getEvictionPolicyClassName()
     */
    public static final String DEFAULT_EVICTION_POLICY_CLASS_NAME =
            "org.apache.commons.pool2.impl.DefaultEvictionPolicy";


    private boolean lifo = DEFAULT_LIFO;

    private long maxWait = DEFAULT_MAX_WAIT;

    private long minEvictableIdleTimeMillis =
        DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS;

    private long softMinEvictableIdleTimeMillis =
            DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS;

    private int numTestsPerEvictionRun =
        DEFAULT_NUM_TESTS_PER_EVICTION_RUN;

    private String evictionPolicyClassName = DEFAULT_EVICTION_POLICY_CLASS_NAME;

    private boolean testOnBorrow = DEFAULT_TEST_ON_BORROW;

    private boolean testOnReturn = DEFAULT_TEST_ON_RETURN;

    private boolean testWhileIdle = DEFAULT_TEST_WHILE_IDLE;

    private long timeBetweenEvictionRunsMillis =
        DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS;

    private boolean blockWhenExhausted = DEFAULT_BLOCK_WHEN_EXHAUSTED;

    private boolean jmxEnabled = DEFAULT_JMX_ENABLE;

    private String jmxNamePrefix = DEFAULT_JMX_NAME_PREFIX;


    /**
     * Get the value for the {@code lifo} configuration attribute for pools
     * created with this configuration instance.
     * @see GenericObjectPool#getLifo()
     * @see GenericKeyedObjectPool#getLifo()
     */
    public boolean getLifo() {
        return lifo;
    }

    /**
     * Set the value for the {@code lifo} configuration attribute for pools
     * created with this configuration instance.
     * @see GenericObjectPool#getLifo()
     * @see GenericKeyedObjectPool#getLifo()
     */
    public void setLifo(boolean lifo) {
        this.lifo = lifo;
    }

    /**
     * Get the value for the {@code maxWait} configuration attribute for pools
     * created with this configuration instance.
     * @see GenericObjectPool#getMaxWait()
     * @see GenericKeyedObjectPool#getMaxWait()
     */
    public long getMaxWait() {
        return maxWait;
    }

    /**
     * Set the value for the {@code maxWait} configuration attribute for pools
     * created with this configuration instance.
     * @see GenericObjectPool#getMaxWait()
     * @see GenericKeyedObjectPool#getMaxWait()
     */
    public void setMaxWait(long maxWait) {
        this.maxWait = maxWait;
    }

    /**
     * Get the value for the {@code minEvictableIdleTimeMillis} configuration
     * attribute for pools created with this configuration instance.
     * @see GenericObjectPool#getMinEvictableIdleTimeMillis()
     * @see GenericKeyedObjectPool#getMinEvictableIdleTimeMillis()
     */
    public long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    /**
     * Set the value for the {@code minEvictableIdleTimeMillis} configuration
     * attribute for pools created with this configuration instance.
     * @see GenericObjectPool#getMinEvictableIdleTimeMillis()
     * @see GenericKeyedObjectPool#getMinEvictableIdleTimeMillis()
     */
    public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    /**
     * Get the value for the {@code softMinEvictableIdleTimeMillis}
     * configuration attribute for pools created with this configuration
     * instance.
     * @see GenericObjectPool#getSoftMinEvictableIdleTimeMillis()
     * @see GenericKeyedObjectPool#getSoftMinEvictableIdleTimeMillis()
     */
    public long getSoftMinEvictableIdleTimeMillis() {
        return softMinEvictableIdleTimeMillis;
    }

    /**
     * Set the value for the {@code softMinEvictableIdleTimeMillis}
     * configuration attribute for pools created with this configuration
     * instance.
     * @see GenericObjectPool#getSoftMinEvictableIdleTimeMillis()
     * @see GenericKeyedObjectPool#getSoftMinEvictableIdleTimeMillis()
     */
    public void setSoftMinEvictableIdleTimeMillis(
            long softMinEvictableIdleTimeMillis) {
        this.softMinEvictableIdleTimeMillis = softMinEvictableIdleTimeMillis;
    }

    /**
     * Get the value for the {@code numTestsPerEvictionRun} configuration
     * attribute for pools created with this configuration instance.
     * @see GenericObjectPool#getNumTestsPerEvictionRun()
     * @see GenericKeyedObjectPool#getNumTestsPerEvictionRun()
     */
    public int getNumTestsPerEvictionRun() {
        return numTestsPerEvictionRun;
    }

    /**
     * Set the value for the {@code numTestsPerEvictionRun} configuration
     * attribute for pools created with this configuration instance.
     * @see GenericObjectPool#getNumTestsPerEvictionRun()
     * @see GenericKeyedObjectPool#getNumTestsPerEvictionRun()
     */
    public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }

    public boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public String getEvictionPolicyClassName() {
        return evictionPolicyClassName;
    }

    public void setEvictionPolicyClassName(String evictionPolicyClassName) {
        this.evictionPolicyClassName = evictionPolicyClassName;
    }

    public boolean getBlockWhenExhausted() {
        return blockWhenExhausted;
    }

    public void setBlockWhenExhausted(boolean blockWhenExhausted) {
        this.blockWhenExhausted = blockWhenExhausted;
    }

    public boolean isJmxEnabled() {
        return jmxEnabled;
    }

    public void setJmxEnabled(boolean jmxEnabled) {
        this.jmxEnabled = jmxEnabled;
    }

    public String getJmxNamePrefix() {
        return jmxNamePrefix;
    }

    public void setJmxNamePrefix(String jmxNamePrefix) {
        this.jmxNamePrefix = jmxNamePrefix;
    }
}