-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购需求', '3', '1', 'requirement', 'procurement/requirement/index', 1, 0, 'C', '0', '0', 'procurement:requirement:list', '#', 'admin', sysdate(), '', null, '采购需求菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购需求查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'procurement:requirement:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购需求新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'procurement:requirement:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购需求修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'procurement:requirement:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购需求删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'procurement:requirement:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('采购需求导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'procurement:requirement:export',       '#', 'admin', sysdate(), '', null, '');