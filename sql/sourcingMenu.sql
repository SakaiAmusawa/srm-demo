-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询价台', '2231', '1', 'sourcing', 'enquiry/sourcing/index', 1, 0, 'C', '0', '0', 'enquiry:sourcing:list', '#', 'admin', sysdate(), '', null, '询价台菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询价台查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'enquiry:sourcing:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询价台新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'enquiry:sourcing:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询价台修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'enquiry:sourcing:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询价台删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'enquiry:sourcing:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询价台导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'enquiry:sourcing:export',       '#', 'admin', sysdate(), '', null, '');