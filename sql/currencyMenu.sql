-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货币定义', '2138', '1', 'currency', 'data/currency/index', 1, 0, 'C', '0', '0', 'data:currency:list', '#', 'admin', sysdate(), '', null, '货币定义菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货币定义查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'data:currency:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货币定义新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'data:currency:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货币定义修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'data:currency:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货币定义删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'data:currency:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('货币定义导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'data:currency:export',       '#', 'admin', sysdate(), '', null, '');