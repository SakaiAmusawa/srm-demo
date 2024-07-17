-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('计量单位类型定义', '2139', '1', 'unity_type_def', 'unity/unity_type_def/index', 1, 0, 'C', '0', '0', 'unity:unity_type_def:list', '#', 'admin', sysdate(), '', null, '计量单位类型定义菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('计量单位类型定义查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'unity:unity_type_def:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('计量单位类型定义新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'unity:unity_type_def:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('计量单位类型定义修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'unity:unity_type_def:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('计量单位类型定义删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'unity:unity_type_def:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('计量单位类型定义导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'unity:unity_type_def:export',       '#', 'admin', sysdate(), '', null, '');