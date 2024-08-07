-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('税率定义', '2138', '1', 'taxdefinition', 'tax/taxdefinition/index', 1, 0, 'C', '0', '0', 'tax:taxdefinition:list', '#', 'admin', sysdate(), '', null, '税率定义菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('税率定义查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'tax:taxdefinition:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('税率定义新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'tax:taxdefinition:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('税率定义修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'tax:taxdefinition:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('税率定义删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'tax:taxdefinition:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('税率定义导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'tax:taxdefinition:export',       '#', 'admin', sysdate(), '', null, '');