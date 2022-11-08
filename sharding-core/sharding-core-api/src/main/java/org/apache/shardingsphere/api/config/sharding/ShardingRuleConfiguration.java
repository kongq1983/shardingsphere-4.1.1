/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.api.config.sharding;

import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.underlying.common.config.RuleConfiguration;
import org.apache.shardingsphere.encrypt.api.EncryptRuleConfiguration;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.ShardingStrategyConfiguration;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Sharding rule configuration.
 */
@Getter
@Setter
public final class ShardingRuleConfiguration implements RuleConfiguration {
    //表规则配置
    private Collection<TableRuleConfiguration> tableRuleConfigs = new LinkedList<>();
    //相同表分片规则的组，如果表分片规则相同，则可以放在一个组里
    private Collection<String> bindingTableGroups = new LinkedList<>();
    // 广播 每个表都会插入
    private Collection<String> broadcastTables = new LinkedList<>();
    //默认数据源名称
    private String defaultDataSourceName;
    //默认数据库的分片算法配置
    private ShardingStrategyConfiguration defaultDatabaseShardingStrategyConfig;
    //默认表的分片算法配置
    private ShardingStrategyConfiguration defaultTableShardingStrategyConfig;
    //默认主键的生成配置
    private KeyGeneratorConfiguration defaultKeyGeneratorConfig;
    //主备配置信息
    private Collection<MasterSlaveRuleConfiguration> masterSlaveRuleConfigs = new LinkedList<>();
    
    private EncryptRuleConfiguration encryptRuleConfig;
}
