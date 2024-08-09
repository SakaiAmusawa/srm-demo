-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询报价模板定义', '2224', '1', 'template_def', 'enquiry/template_def/index', 1, 0, 'C', '0', '0', 'enquiry:template_def:list', '#', 'admin', sysdate(), '', null, '询报价模板定义菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询报价模板定义查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'enquiry:template_def:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询报价模板定义新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'enquiry:template_def:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询报价模板定义修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'enquiry:template_def:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询报价模板定义删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'enquiry:template_def:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('询报价模板定义导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'enquiry:template_def:export',       '#', 'admin', sysdate(), '', null, '');