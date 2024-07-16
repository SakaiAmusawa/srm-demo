-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商现场考察', '2125', '1', 'visit', 'inspect/visit/index', 1, 0, 'C', '0', '0', 'inspect:visit:list', '#', 'admin', sysdate(), '', null, '供应商现场考察菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商现场考察查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'inspect:visit:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商现场考察新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'inspect:visit:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商现场考察修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'inspect:visit:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商现场考察删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'inspect:visit:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('供应商现场考察导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'inspect:visit:export',       '#', 'admin', sysdate(), '', null, '');